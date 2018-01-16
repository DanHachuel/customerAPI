/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl;

import model.service.certification.enums.CertificationResult;

/**
 *
 * @author G0042204
 */
public abstract class Certificational {

    private CertificationResult resultado;

    private String orientacao;

    public final void concluir(CertificationResult resultado, String orientacao) {
        this.resultado = resultado;
        this.orientacao = orientacao;
    }

    protected abstract void check();

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

}
