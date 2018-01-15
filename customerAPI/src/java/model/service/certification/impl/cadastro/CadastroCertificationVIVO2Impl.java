/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl.cadastro;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.service.assertations.CustomerCertificationAsserter;
import model.service.certification.enums.CertificationAssertName;
import model.service.certification.enums.CertificationResult;

public class CadastroCertificationVIVO2Impl extends CadastroCertification {

    public CadastroCertificationVIVO2Impl() {
    }

    @Override
    protected void process() {
        if (this.getSubject().getRede() != null) {
            try {
                this.getAsserts().add(new CustomerCertificationAsserter().assertCertification(CertificationAssertName.HAS_BLOQ_RADIUS, getSubject()));
                this.getAsserts().add(new CustomerCertificationAsserter().assertCertification(CertificationAssertName.IS_TBS_EQUALS_RADIUS, getSubject()));
            } catch (Exception ex) {
                Logger.getLogger(CadastroCertificationVIVO2Impl.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.concluir(CertificationResult.OK, "Cadastro OK");
        } else {
            this.concluir(CertificationResult.FORWARDED_CO, "Cadastro NOK.");
        }
    }

}