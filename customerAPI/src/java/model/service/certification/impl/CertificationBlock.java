/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl;

import java.util.ArrayList;
import java.util.List;
import model.service.certification.enums.CertificationBlockName;
import model.service.certification.enums.CertificationResult;

/**
 *
 * @author G0041775
 * @param <T>
 */
public abstract class CertificationBlock<T> implements Certificable<T> {

    private List<CertificationAssert> asserts;

    private CertificationResult resultado;

    private String orientacao;

    private CertificationBlockName nome;

    private T subject;

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

    public CertificationResult getResultado() {
        return resultado;
    }

    public void setResultado(CertificationResult resultado) {
        this.resultado = resultado;
    }

    public String getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(String orientacao) {
        this.orientacao = orientacao;
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

    protected final void check() {
        for (CertificationAssert aAssert : getAsserts()) {
            if (aAssert.getResultado() == CertificationResult.TO_FIX) {
                this.concluir(aAssert.getResultado(), aAssert.getOrientacao());
                break;
            }
            
        }
    }

    protected final void concluir(CertificationResult resultado, String orientacao) {
        this.resultado = resultado;
        this.orientacao = orientacao;
    }

    public T getSubject() {
        return subject;
    }

}
