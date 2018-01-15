/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import model.service.certification.impl.CertificationBlock;
import fulltest.FullTest;
import java.util.ArrayList;
import java.util.List;
import model.service.certification.enums.CertificationResult;
import org.mongodb.morphia.annotations.Embedded;

public class CustomerLogCertification extends CustomerLog {

    @Embedded
    private FullTest output;

    private CertificationResult resultado;

    private String orientacao;

    @Embedded
    private List<CertificationBlock> certificationBlocks;

    public CustomerLogCertification() {
    }

    public FullTest getOutput() {
        return output;
    }

    public void setOutput(FullTest output) {
        this.output = output;
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

    public List<CertificationBlock> getCertificationBlocks() {
        if (certificationBlocks == null) {
            this.certificationBlocks = new ArrayList<>();
        }
        return certificationBlocks;
    }

    public void setCertificationBlocks(List<CertificationBlock> certificationBlocks) {
        this.certificationBlocks = certificationBlocks;
    }

}
