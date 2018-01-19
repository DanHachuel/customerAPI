/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certificator.impl;

import br.net.gvt.efika.model.certification.enuns.CertificationAssertName;
import br.net.gvt.efika.model.certification.enuns.CertificationResult;
import fulltest.FullTest;
import model.service.assertations.FulltestCertificationAsserter;
import model.service.certification.command.NonExceptionCommand;

public class CertifierConectividadeCertificationImpl extends CertifierCertificationBlockGeneric {

    private FullTest fulltest;

    public CertifierConectividadeCertificationImpl() {
    }

    public CertifierConectividadeCertificationImpl(FullTest fulltest) {
        this.fulltest = fulltest;
    }

    @Override
    protected void process() {
        if (fulltest != null) {
            for (CertificationAssertName value : getAsserts()) {
                new NonExceptionCommand() {
                    @Override
                    public void run() throws Exception {
                        CertifierConectividadeCertificationImpl.this.getBlock().getAsserts().add(new FulltestCertificationAsserter().assertCertification(value, CertifierConectividadeCertificationImpl.this.fulltest));
                    }
                };
            }
            this.check();
        } else {
            getBlock().concluir(CertificationResult.FORWARDED_CO, "Conectividade NOK.");
        }

    }

    @Override
    public void definirAsserts() {
        this.asserts.add(CertificationAssertName.IS_ADM_UP);
        this.asserts.add(CertificationAssertName.IS_OPER_UP);
        this.asserts.add(CertificationAssertName.IS_PARAM_OK);
        this.asserts.add(CertificationAssertName.IS_MODUL_OK);
        this.asserts.add(CertificationAssertName.IS_ONT_ASSOC);
        this.asserts.add(CertificationAssertName.IS_VIZINHO_OK);
        this.asserts.add(CertificationAssertName.HAS_MAC_DSLAM);
    }

}
