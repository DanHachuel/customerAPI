/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import br.net.gvt.efika.customer.CustomerAssert;
import fulltest.FullTest;
import java.util.List;
import model.entity.enums.CertificationResult;
import org.mongodb.morphia.annotations.Embedded;

public class CustomerLogCertification extends CustomerLog {

    @Embedded
    private FullTest output;

    private CertificationResult resultado;

    private String orientacao;

    @Embedded
    private List<CustomerAssert> asserts;

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

    public List<CustomerAssert> getAsserts() {
        return asserts;
    }

    public void setAsserts(List<CustomerAssert> asserts) {
        this.asserts = asserts;
    }

}
