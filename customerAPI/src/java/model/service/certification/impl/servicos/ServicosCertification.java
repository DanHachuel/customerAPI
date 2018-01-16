/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl.servicos;

import fulltest.FullTest;
import model.service.certification.impl.CertificationBlock;
import model.service.certification.enums.CertificationBlockName;
import model.service.certification.enums.CertificationResult;

public class ServicosCertification extends CertificationBlock<FullTest> {

    public ServicosCertification() {
        super(CertificationBlockName.SERVICOS);
    }

    @Override
    protected void process() {
        this.concluir(CertificationResult.OK, "OK");
    }

}
