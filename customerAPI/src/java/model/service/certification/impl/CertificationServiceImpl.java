/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl;

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
import model.service.certification.enums.CertificationBlockName;
import model.service.certification.enums.CertificationResult;
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
            List<Thread> threads = new ArrayList<>();
            
            threads.add(new Thread(new LogCommand(certification) {
                @Override
                public void run() {
                    try {
                        CertificationBlock<FullTest> perfBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.PERFORMANCE, cust).certify(fulltest);
                        certification.getBlocks().add(perfBlock);
                    } catch (Exception e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    }
                }
            }));
            
            threads.add(new Thread(new LogCommand(certification) {
                @Override
                public void run() {
                    try {
                        CertificationBlock<FullTest> perfBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.CONECTIVIDADE, cust).certify(fulltest);
                        certification.getBlocks().add(perfBlock);
                    } catch (Exception e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    }
                }
            }));
            
            threads.add(new Thread(new LogCommand(certification) {
                @Override
                public void run() {
                    try {
                        CertificationBlock<FullTest> servBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.SERVICOS, cust).certify(fulltest);
                        certification.getBlocks().add(servBlock);
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
