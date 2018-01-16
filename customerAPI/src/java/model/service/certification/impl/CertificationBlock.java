/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import model.service.certification.enums.CertificationBlockName;
import model.service.certification.enums.CertificationResult;

/**
 *
 * @author G0041775
 * @param <T>
 */
@JsonIgnoreProperties({"subject"})
public abstract class CertificationBlock<T> extends Certificational implements Certificable<T> {

    private List<CertificationAssert> asserts;

    private CertificationBlockName nome;

    private transient T subject;

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

    protected abstract void process();

    @Override
    public CertificationBlock certify(T t) {
        this.subject = t;
        this.process();
        return this;
    }

    @Override
    protected final void check() {
        for (CertificationAssert aAssert : getAsserts()) {
            if (aAssert.getResultado() == CertificationResult.FORWARDED_CO) {
                this.concluir(aAssert.getResultado(), aAssert.getOrientacao());
                break;
            }

            if (aAssert.getResultado() == CertificationResult.TO_FIX) {
                this.concluir(aAssert.getResultado(), aAssert.getOrientacao());
                break;
            }

            if (aAssert.getResultado() == CertificationResult.FIXED) {
                this.concluir(aAssert.getResultado(), aAssert.getOrientacao());
                break;
            }

            if (aAssert.getResultado() == CertificationResult.FISICAL) {
                this.concluir(aAssert.getResultado(), aAssert.getOrientacao());
                break;
            }

        }

        if (this.getOrientacao() == null) {
            this.concluir(CertificationResult.OK, this.getNome().name() + " OK.");
        }
    }

    public T getSubject() {
        return subject;
    }

}
