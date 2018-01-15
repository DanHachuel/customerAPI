/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl.cadastro;

import model.service.certification.enums.CertificationResult;

public class CadastroCertificationVIVO2Impl extends CadastroCertification {

    public CadastroCertificationVIVO2Impl() {
    }

    @Override
    protected void process() {
        if (this.getSubject().getRede() != null) {
            this.concluir(CertificationResult.OK, "Cadastro OK");
        } else {
            this.concluir(CertificationResult.FORWARDED_CO, "Cadastro NOK.");
        }
    }

}
