/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certificator;

import br.net.gvt.efika.customer.model.certification.CertificationBlock;
import br.net.gvt.efika.customer.model.certification.enums.CertificationResult;
import br.net.gvt.efika.customerAPI.model.entity.CustomerCertification;



public class CertifierCustomerCertificationImpl extends CertifierAbstract<CustomerCertification> {

    private CustomerCertification certification;

    @Override
    public void check() {
        for (CertificationBlock block : certification.getBlocks()) {

            if (block.getResultado() == CertificationResult.FORWARDED_CO) {
                certification.concluir(block.getResultado(), block.getOrientacao());
                break;
            }

            if (block.getResultado() == CertificationResult.TO_FIX) {
                certification.concluir(block.getResultado(), block.getOrientacao());
                break;
            }

            if (block.getResultado() == CertificationResult.FIXED) {
                certification.concluir(block.getResultado(), block.getOrientacao());
                break;
            }

            if (block.getResultado() == CertificationResult.FISICAL) {
                certification.concluir(block.getResultado(), block.getOrientacao());
                break;
            }

        }

        if (certification.getOrientacao() == null) {
            certification.concluir(CertificationResult.OK, "OK");
        }
        
    }

    @Override
    protected void process() {
        this.check();
    }

    @Override
    public void certify(CustomerCertification t) {
        this.certification = t;
        this.process();
    }

}
