/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl.cadastro;

import model.service.factory.FactoryCertificationAssert;
import model.service.certification.enums.CertificationAssertName;
import model.service.certification.enums.CertificationResult;

public class CadastroCertificationVIVO1Impl extends CadastroCertification {

    public CadastroCertificationVIVO1Impl() {
    }

    @Override
    protected void process() {
        this.getAsserts().add(
                FactoryCertificationAssert.createAssertByName(
                        CertificationAssertName.IS_ADM_UP, CertificationResult.FISICAL, "orientacao"
                )
        );
        this.concluir(CertificationResult.FORWARDED_CO, "Sigres fora.");
    }

}
