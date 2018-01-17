/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl.performance;

import fulltest.FullTest;
import model.service.assertations.FulltestCertificationAsserter;
import model.service.certification.command.NonExceptionCommand;
import model.enums.CertificationAssertName;
import model.entity.CertificationBlock;
import model.enums.CertificationBlockName;
import model.enums.CertificationResult;

public class PerformanceCertification extends CertificationBlock<FullTest> {

    public PerformanceCertification() {
        super(CertificationBlockName.PERFORMANCE);
    }

    @Override
    protected void process() {
        if (this.getSubject() != null) {

            new NonExceptionCommand() {
                @Override
                public void run() throws Exception {
                    PerformanceCertification.this.getAsserts().add(new FulltestCertificationAsserter().assertCertification(CertificationAssertName.HAS_MAC_DSLAM, getSubject()));
                }
            };

            new NonExceptionCommand() {
                @Override
                public void run() throws Exception {
                    PerformanceCertification.this.getAsserts().add(new FulltestCertificationAsserter().assertCertification(CertificationAssertName.IS_REDE_BANDA_OK, getSubject()));
                }
            };
            this.check();
        } else {
            this.concluir(CertificationResult.FORWARDED_CO, "Cadastro NOK.");
        }
    }

}
