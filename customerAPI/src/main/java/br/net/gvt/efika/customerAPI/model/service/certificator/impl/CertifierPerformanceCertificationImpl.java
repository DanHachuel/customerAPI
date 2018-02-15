/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certificator.impl;

import br.net.gvt.efika.model.certification.enuns.CertificationAssertName;
import br.net.gvt.efika.model.certification.enuns.CertificationResult;
import fulltest.FullTest;
import br.net.gvt.efika.customerAPI.model.service.assertations.FulltestCertificationAsserter;
import br.net.gvt.efika.customerAPI.model.service.certification.command.NonExceptionCommand;

public class CertifierPerformanceCertificationImpl extends CertifierCertificationBlockGeneric {

    private FullTest fulltest;

    public CertifierPerformanceCertificationImpl() {
    }

    public CertifierPerformanceCertificationImpl(FullTest fulltest) {
        this.fulltest = fulltest;
    }

    @Override
    protected void process() {
        if (fulltest != null) {
            for (CertificationAssertName value : getAsserts()) {
                new NonExceptionCommand() {
                    @Override
                    public void run() throws Exception {
                        CertifierPerformanceCertificationImpl.this.getBlock().getAsserts().add(new FulltestCertificationAsserter().assertCertification(value, CertifierPerformanceCertificationImpl.this.fulltest));
                    }
                };
            }
            this.check();
        } else {
            getBlock().concluir(CertificationResult.FORWARDED_CO, "Performance NOK.");
        }

    }

    @Override
    public void definirAsserts() {
        this.asserts.add(CertificationAssertName.IS_REDE_BANDA_OK);
    }

}
