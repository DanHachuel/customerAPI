package br.net.gvt.efika.customerAPI.model.service.certification.impl;

import br.net.gvt.efika.customerAPI.model.entity.CustomerCertification;
import br.net.gvt.efika.customer.model.certification.CertificationBlock;
import br.net.gvt.efika.customer.model.certification.enums.CertificationBlockName;
import br.net.gvt.efika.customer.model.certification.enums.CertificationResult;
import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.dao.configporta.ConfigPortaDAO;
import br.net.gvt.efika.customerAPI.dao.factory.FactoryDAO;
import br.net.gvt.efika.customerAPI.dao.fulltest.FulltestDAO;
import br.net.gvt.efika.customerAPI.model.GenericRequest;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.net.gvt.efika.customerAPI.model.entity.ExceptionLog;
import br.net.gvt.efika.customerAPI.model.service.certification.command.LogCommand;
import br.net.gvt.efika.customerAPI.model.service.certificator.CertifierCustomerCertificationImpl;
import br.net.gvt.efika.customerAPI.model.service.factory.FactoryEntitiy;
import br.net.gvt.efika.customerAPI.model.service.certificator.impl.CertifierCadastroCertificationImpl;
import br.net.gvt.efika.customerAPI.model.service.certificator.impl.CertifierConectividadeCertificationImpl;
import br.net.gvt.efika.customerAPI.model.service.certificator.impl.CertifierPerformanceCertificationImpl;
import br.net.gvt.efika.customerAPI.model.service.certificator.impl.CertifierServicosCertificationImpl;
import br.net.gvt.efika.customerAPI.model.service.factory.FactoryCertificationBlock;
import br.net.gvt.efika.customerAPI.model.service.factory.FactoryService;
import br.net.gvt.efika.customerAPI.model.service.finder.CustomerFinder;
import br.net.gvt.efika.fulltest.FullTest;
import br.net.gvt.efika.fulltest.FulltestRequest;
import br.net.gvt.efika.fulltest.SetOntToOltRequest;
import br.net.gvt.efika.fulltest.ValidacaoResult;
import br.net.gvt.efika.telecom.properties.gpon.SerialOntGpon;

public class CertificationServiceImpl implements CertificationService {

    private final CustomerFinder finder = FactoryService.customerFinder();
    private final CustomerCertification certification = FactoryEntitiy.createCustLogCertification();
    private final FulltestDAO ftDAO = FactoryDAO.newFulltestDAO();
    private final ConfigPortaDAO confPortaDAO = FactoryDAO.newConfigPortaDAO();

    private EfikaCustomer cust;

    @Override
    public CustomerCertification certificationByParam(GenericRequest req) throws Exception {
        if (req.getCustomer() == null) {
            cust = FactoryService.customerFinder().getCustomer(req);
        } else {
            cust = req.getCustomer();
        }
        this.certification.setCustomer(cust);
        this.certification.setExecutor(req.getExecutor());

        CertificationBlock cadastro = FactoryCertificationBlock.createBlockByName(CertificationBlockName.CADASTRO);
        new CertifierCadastroCertificationImpl(cust).certify(cadastro);
        this.certification.getBlocks().add(cadastro);

        if (cadastro.getResultado() == CertificationResult.OK) {
            FullTest fulltest = ftDAO.fulltest(new FulltestRequest(cust, req.getExecutor()));
            this.certification.setFulltest(fulltest);

            Thread threadPerf = new Thread(new LogCommand(certification) {
                @Override
                public void run() {
                    try {
                        CertificationBlock perfBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.PERFORMANCE);
                        new CertifierPerformanceCertificationImpl(fulltest).certify(perfBlock);
                        certification.getBlocks().add(perfBlock);
                    } catch (Exception e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    }
                }
            });

            Thread threadConnect = new Thread(new LogCommand(certification) {
                @Override
                public void run() {
                    try {
                        CertificationBlock connectBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.CONECTIVIDADE);
                        new CertifierConectividadeCertificationImpl(fulltest).certify(connectBlock);
                        certification.getBlocks().add(connectBlock);
                    } catch (Exception e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    }
                }
            });

            Thread threadServ = new Thread(new LogCommand(certification) {
                @Override
                public void run() {
                    try {
                        CertificationBlock servBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.SERVICOS);
                        new CertifierServicosCertificationImpl(fulltest).certify(servBlock);
                        certification.getBlocks().add(servBlock);
                    } catch (Exception e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    }
                }
            });

            threadPerf.start();
            threadConnect.start();
            threadServ.start();

            threadPerf.join();
            threadConnect.join();
            threadServ.join();
        }
        this.conclude();
        return certification;
    }

    protected void conclude() throws Exception {
        new CertifierCustomerCertificationImpl().certify(certification);
        certification.setDataFim(Calendar.getInstance().getTime());
        certification.setDataFim(Calendar.getInstance().getTime());
        FactoryDAO.createCertificationLogDAO().save(certification);
    }

    @Override
    public List<CustomerCertification> findByCustomer(EfikaCustomer cust) throws Exception {
        try {
            return FactoryDAO.createCertificationLogDAO().findByCustomer(cust);
        } catch (Exception e) {
            FactoryDAO.newExceptionLogDAO().save(new ExceptionLog(e));
            throw new Exception("Falha ao buscar histórico de execuções.");
        }
    }

    @Override
    public ValidacaoResult certifyRede(GenericRequest req) throws Exception {
        if (req.getCustomer() == null) {
            cust = finder.getCustomer(req);
        } else {
            cust = req.getCustomer();
        }
        ValidacaoResult confRede = confPortaDAO.confiabilidadeRede(new FulltestRequest(cust, req.getExecutor()));

        return confRede;
    }

    @Override
    public List<SerialOntGpon> ontsDisp(GenericRequest req) throws Exception {
        if (req.getCustomer() == null) {
            cust = finder.getCustomer(req);
        } else {
            cust = req.getCustomer();
        }
        List<SerialOntGpon> ontsDisp = confPortaDAO.ontsDisponiveis(new FulltestRequest(cust, req.getExecutor()));

        return ontsDisp;
    }

    @Override
    public ValidacaoResult setOntToOlt(GenericRequest req) throws Exception {
        if (req.getCustomer() == null) {
            cust = finder.getCustomer(req);
        } else {
            cust = req.getCustomer();
        }

        ValidacaoResult settedOnt = confPortaDAO.setOntToOlt(new SetOntToOltRequest(cust, req.getExecutor(), new SerialOntGpon(req.getParameter())));

        return settedOnt;
    }

}
