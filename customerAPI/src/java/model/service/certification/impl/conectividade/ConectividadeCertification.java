/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl.conectividade;

import fulltest.FullTest;
import model.service.assertations.FulltestCertificationAsserter;
import model.service.certification.command.NonExceptionCommand;
import model.service.certification.enums.CertificationAssertName;
import model.service.certification.impl.CertificationBlock;
import model.service.certification.enums.CertificationBlockName;
import model.service.certification.enums.CertificationResult;

public class ConectividadeCertification extends CertificationBlock<FullTest> {

    public ConectividadeCertification() {
        super(CertificationBlockName.CONECTIVIDADE);
    }

    @Override
    protected void process() {
        if (this.getSubject() != null) {

            new NonExceptionCommand() {
                @Override
                public void run() throws Exception {
                    ConectividadeCertification.this.getAsserts().add(new FulltestCertificationAsserter().assertCertification(CertificationAssertName.HAS_MAC_DSLAM, getSubject()));
                }
            };

            new NonExceptionCommand() {
                @Override
                public void run() throws Exception {
                    ConectividadeCertification.this.getAsserts().add(new FulltestCertificationAsserter().assertCertification(CertificationAssertName.IS_ADM_UP, getSubject()));
                }
            };

            this.concluir(CertificationResult.OK, "Cadastro OK");
        } else {
            this.concluir(CertificationResult.FORWARDED_CO, "Cadastro NOK.");
        }
    }

}
