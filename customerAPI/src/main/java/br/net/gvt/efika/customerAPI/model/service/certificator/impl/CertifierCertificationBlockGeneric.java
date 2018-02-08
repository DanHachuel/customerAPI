/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certificator.impl;

import br.net.gvt.efika.model.certification.CertificationAssert;
import br.net.gvt.efika.model.certification.CertificationBlock;
import br.net.gvt.efika.model.certification.enuns.CertificationAssertName;
import br.net.gvt.efika.model.certification.enuns.CertificationResult;
import java.util.ArrayList;
import java.util.List;

import br.net.gvt.efika.customerAPI.model.service.certificator.CertifierAbstract;

public abstract class CertifierCertificationBlockGeneric extends CertifierAbstract<CertificationBlock> {

    private CertificationBlock block;

    protected List<CertificationAssertName> asserts = new ArrayList<>();

    
    @Override
    public void certify(CertificationBlock t) {
        this.block = t;
        this.definirAsserts();
        this.process();
    }

    @Override
    public final void check() {
        for (CertificationAssert aAssert : block.getAsserts()) {
            if (aAssert.getResultado() == CertificationResult.FORWARDED_CO) {
                block.concluir(aAssert.getResultado(), aAssert.getOrientacao());
                break;
            }

            if (aAssert.getResultado() == CertificationResult.TO_FIX) {
                block.concluir(aAssert.getResultado(), aAssert.getOrientacao());
                break;
            }

            if (aAssert.getResultado() == CertificationResult.FIXED) {
                block.concluir(aAssert.getResultado(), aAssert.getOrientacao());
                break;
            }

            if (aAssert.getResultado() == CertificationResult.FISICAL) {
                block.concluir(aAssert.getResultado(), aAssert.getOrientacao());
                break;
            }

        }

        if (block.getOrientacao() == null) {
            block.concluir(CertificationResult.OK, "OK");
        }
    }

    public CertificationBlock getBlock() {
        return block;
    }

    public void setBlock(CertificationBlock block) {
        this.block = block;
    }

    public abstract void definirAsserts();

    public List<CertificationAssertName> getAsserts() {
        return asserts;
    }

    public void setAsserts(List<CertificationAssertName> asserts) {
        this.asserts = asserts;
    }

}
