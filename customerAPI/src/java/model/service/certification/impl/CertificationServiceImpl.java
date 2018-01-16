/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl;

import br.net.gvt.efika.customer.EfikaCustomer;
import dao.factory.FactoryDAO;
import dao.fulltest.FulltestDAO;
import dao.log.CertificationLogDAO;
import fulltest.FullTest;
import fulltest.FulltestRequest;
import io.swagger.model.GenericRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entity.CustomerLogCertification;
import model.service.certification.command.LogCommand;
import model.service.factory.FactoryCertificationBlock;
import model.service.factory.FactoryEntitiy;
import model.service.certification.enums.CertificationBlockName;
import model.service.certification.enums.CertificationResult;
import model.service.finder.CustomerFinder;
import model.service.factory.FactoryService;

public class CertificationServiceImpl implements CertificationService {

    private final CustomerFinder finder = FactoryService.customerFinder();
    private final CustomerLogCertification resultado = FactoryEntitiy.createCustLogCertification();
    private final FulltestDAO ftDAO = FactoryDAO.newFulltestDAO();
    private final CertificationLogDAO certDAO = FactoryDAO.createCertificationLogDAO();
    private static final Logger LOG = Logger.getLogger(CertificationServiceImpl.class.getName());

    @Override
    public CustomerLogCertification certificationByParam(GenericRequest req) throws Exception {
        EfikaCustomer cust = finder.getCustomer(req);

        CertificationBlock<EfikaCustomer> cadastro = FactoryCertificationBlock.createBlockByName(CertificationBlockName.CADASTRO, cust).certify(cust);
        this.addBlock(cadastro);

        if (cadastro.getResultado() == CertificationResult.OK) {
            FullTest fulltest = ftDAO.fulltest(new FulltestRequest(cust, req.getExecutor()));

            List<Thread> threads = new ArrayList<>();

            threads.add(new Thread(new LogCommand(resultado) {
                @Override
                public void run() {
                    try {
                        CertificationBlock<FullTest> perfBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.PERFORMANCE, cust).certify(fulltest);
                        resultado.getCertificationBlocks().add(perfBlock);
                    } catch (Exception e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    }
                }
            }));

            threads.add(new Thread(new LogCommand(resultado) {
                @Override
                public void run() {
                    try {
                        CertificationBlock<FullTest> perfBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.CONECTIVIDADE, cust).certify(fulltest);
                        resultado.getCertificationBlocks().add(perfBlock);
                    } catch (Exception e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    }
                }
            }));

            threads.add(new Thread(new LogCommand(resultado) {
                @Override
                public void run() {
                    try {
                        CertificationBlock<FullTest> servBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.SERVICOS, cust).certify(fulltest);
                        resultado.getCertificationBlocks().add(servBlock);
                    } catch (Exception e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    }
                }
            }));

            threads.forEach((t) -> {
                t.start();
                System.out.println("started" + Calendar.getInstance());
            });
            threads.forEach((t) -> {
                try {
                    t.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CertificationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } else {
            this.resultado.setResultado(cadastro.getResultado());
            this.resultado.setOrientacao(cadastro.getOrientacao());
        }

        this.conclude();
        return resultado;
    }

    protected void addBlock(CertificationBlock block) {
        this.resultado.getCertificationBlocks().add(block);
    }

    protected void conclude() throws Exception {
        resultado.setDataFim(Calendar.getInstance().getTime());
        certDAO.save(resultado);
    }

}
