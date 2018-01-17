/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl.cadastro;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.service.assertations.CustomerCertificationAsserter;
import model.service.certification.command.NonExceptionCommand;
import model.enums.CertificationAssertName;
import model.enums.CertificationResult;

public class CadastroCertificationVIVO2Impl extends CadastroCertification {

    public CadastroCertificationVIVO2Impl() {
    }

    @Override
    protected void process() {
        if (this.getSubject().getRede() != null) {

            new NonExceptionCommand() {
                @Override
                public void run() throws Exception {
                    CadastroCertificationVIVO2Impl.this.getAsserts().add(new CustomerCertificationAsserter().assertCertification(CertificationAssertName.HAS_BLOQ_RADIUS, getSubject()));
                }
            };

            new NonExceptionCommand() {
                @Override
                public void run() throws Exception {
                    CadastroCertificationVIVO2Impl.this.getAsserts().add(new CustomerCertificationAsserter().assertCertification(CertificationAssertName.IS_INV_REDE_EQUALS_RADIUS, getSubject()));
                }
            };
            
            this.check();
        } else {
            this.concluir(CertificationResult.FORWARDED_CO, "Cadastro NOK.");
        }
    }

}
