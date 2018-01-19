/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certificator;

import model.entity.CertificationBlock;
import model.entity.CustomerCertification;
import model.enums.CertificationResult;

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
