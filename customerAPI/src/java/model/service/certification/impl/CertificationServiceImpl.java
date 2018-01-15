/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl;

import br.net.gvt.efika.customer.EfikaCustomer;
import dao.factory.FactoryDAO;
import dao.fulltest.FulltestDAO;
import fulltest.FullTest;
import fulltest.FulltestRequest;
import io.swagger.model.GenericRequest;
import model.entity.CustomerLogCertification;
import model.service.factory.FactoryCertificationBlock;
import model.service.factory.FactoryEntitiy;
import model.service.certification.enums.CertificationBlockName;
import model.service.certification.enums.CertificationResult;
import model.service.finder.CustomerFinder;
import model.service.factory.FactoryService;

public class CertificationServiceImpl implements CertificationService {

    private final CustomerFinder finder = FactoryService.customerFinder();
    private CustomerLogCertification resultado = FactoryEntitiy.createCustLogCertification();
    private FulltestDAO ftDAO = FactoryDAO.newFulltestDAO();

    @Override
    public CustomerLogCertification certificationByParam(GenericRequest req) throws Exception {
        EfikaCustomer cust = finder.getCustomer(req);

        CertificationBlock<EfikaCustomer> cadastro = FactoryCertificationBlock.createBlockByName(CertificationBlockName.CADASTRO, cust).certify(cust);
        this.addBlock(cadastro);
        if (cadastro.getResultado() == CertificationResult.OK) {
            FullTest fulltest = ftDAO.fulltest(new FulltestRequest(cust, req.getExecutor()));

            CertificationBlock<FullTest> conectBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.CONECTIVIDADE, cust).certify(fulltest);
            this.addBlock(conectBlock);

            CertificationBlock<FullTest> perfBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.PERFORMANCE, cust).certify(fulltest);
            this.addBlock(perfBlock);

            CertificationBlock<FullTest> servBlock = FactoryCertificationBlock.createBlockByName(CertificationBlockName.SERVICOS, cust).certify(fulltest);
            this.addBlock(servBlock);

        } else {

        }

        return resultado;
    }

    protected void addBlock(CertificationBlock block) {
        this.resultado.getCertificationBlocks().add(block);
    }

}
