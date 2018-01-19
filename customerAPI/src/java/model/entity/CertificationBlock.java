/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.ArrayList;
import java.util.List;
import model.enums.CertificationBlockName;

/**
 *
 * @author G0041775
 */
public class CertificationBlock extends Certificational {

    private List<CertificationAssert> asserts;

    private CertificationBlockName nome;

    public CertificationBlock(CertificationBlockName nome) {
        this.nome = nome;
    }

    public List<CertificationAssert> getAsserts() {
        if (asserts == null) {
            asserts = new ArrayList<>();
        }
        return asserts;
    }

    public void setAsserts(List<CertificationAssert> asserts) {
        this.asserts = asserts;
    }

    public CertificationBlockName getNome() {
        return nome;
    }

    public void setNome(CertificationBlockName nome) {
        this.nome = nome;
    }

//    protected abstract void process();

//    @Override
//    public CertificationBlock certify(T t) {
//        this.subject = t;
//        this.process();
//        return this;
//    }
//
//    @Override
//    public final void check() {
//        for (CertificationAssert aAssert : getAsserts()) {
//            if (aAssert.getResultado() == CertificationResult.FORWARDED_CO) {
//                this.concluir(aAssert.getResultado(), aAssert.getOrientacao());
//                break;
//            }
//
//            if (aAssert.getResultado() == CertificationResult.TO_FIX) {
//                this.concluir(aAssert.getResultado(), aAssert.getOrientacao());
//                break;
//            }
//
//            if (aAssert.getResultado() == CertificationResult.FIXED) {
//                this.concluir(aAssert.getResultado(), aAssert.getOrientacao());
//                break;
//            }
//
//            if (aAssert.getResultado() == CertificationResult.FISICAL) {
//                this.concluir(aAssert.getResultado(), aAssert.getOrientacao());
//                break;
//            }
//
//        }
//
//        if (this.getOrientacao() == null) {
//            this.concluir(CertificationResult.OK, this.getNome().name() + " OK.");
//        }
//    }
//
//    public T getSubject() {
//        return subject;
//    }

}
