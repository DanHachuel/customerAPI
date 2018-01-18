/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl;

import model.entity.CertificationBlock;
import model.entity.CustomerCertification;
import br.net.gvt.efika.customer.EfikaCustomer;
import dao.factory.FactoryDAO;
import dao.fulltest.FulltestDAO;
import dao.log.CertificationDAO;
import fulltest.FullTest;
import fulltest.FulltestRequest;
import io.swagger.model.GenericRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.service.certification.command.LogCommand;
import model.service.factory.FactoryCertificationBlock;
import model.service.factory.FactoryEntitiy;
import model.enums.CertificationBlockName;
import model.enums.CertificationResult;
import model.service.finder.CustomerFinder;
import model.service.factory.FactoryService;

public class CertificationServiceImpl implements CertificationService {

    private final CustomerFinder finder = FactoryService.customerFinder();
    private final CustomerCertification certification = FactoryEntitiy.createCustLogCertification();
    private final FulltestDAO ftDAO = FactoryDAO.newFulltestDAO();
    private final CertificationDAO certDAO = FactoryDAO.createCertificationLogDAO();

    private EfikaCustomer cust;

    @Override
    public CustomerCertification certificationByParam(GenericRequest req) throws Exception {
        if (req.getCustomer() == null) {
            cust = finder.getCustomer(req);
        } else {
            cust = req.getCustomer();
        }
        this.certification.setCustomer(cust);
        this.certification.setExecutor(req.getExecutor());

        CertificationBlock<EfikaCustomer> cadastro = FactoryCertificationBlock.createBlockByName(CertificationBlockName.CADASTRO, cust).certify(cust);
        this.certification.getBlocks().add(cadastro);

        if (cadastro.getResultado() == CertificationResult.OK) {
            FullTest fulltest = ftDAO.fulltest(new FulltestRequest(cust, req.getExecutor()));
            this.certification.setFulltest(fulltest);

            Thread threadPerf = new Thread(new LogCommand(certification) {
                @Override
                public void run() {
                    try {
                        CertificationBlock<FullTest> perfBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.PERFORMANCE, cust).certify(fulltest);
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
                        CertificationBlock<FullTest> connectBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.CONECTIVIDADE, cust).certify(fulltest);
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
                        CertificationBlock<FullTest> servBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.SERVICOS, cust).certify(fulltest);
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
        certification.check();
        certification.setDataFim(Calendar.getInstance().getTime());
        certification.setDataFim(Calendar.getInstance().getTime());
        certDAO.save(certification);
    }

}
