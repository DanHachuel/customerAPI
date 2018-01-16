/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl.servicos;

import fulltest.FullTest;
import model.service.assertations.FulltestCertificationAsserter;
import model.service.certification.command.NonExceptionCommand;
import model.service.certification.enums.CertificationAssertName;
import model.service.certification.impl.CertificationBlock;
import model.service.certification.enums.CertificationBlockName;
import model.service.certification.enums.CertificationResult;

public class ServicosCertification extends CertificationBlock<FullTest> {

    public ServicosCertification() {
        super(CertificationBlockName.SERVICOS);
    }

    @Override
    protected void process() {
        if (this.getSubject() != null) {

            new NonExceptionCommand() {
                @Override
                public void run() throws Exception {
                    ServicosCertification.this.getAsserts().add(new FulltestCertificationAsserter().assertCertification(CertificationAssertName.IS_VLANS_OK, getSubject()));
                }
            };

            new NonExceptionCommand() {
                @Override
                public void run() throws Exception {
                    ServicosCertification.this.getAsserts().add(new FulltestCertificationAsserter().assertCertification(CertificationAssertName.IS_PROFILE_OK, getSubject()));
                }
            };
            this.check();
        } else {
            this.concluir(CertificationResult.FORWARDED_CO, "Cadastro NOK.");
        }
    }

}
