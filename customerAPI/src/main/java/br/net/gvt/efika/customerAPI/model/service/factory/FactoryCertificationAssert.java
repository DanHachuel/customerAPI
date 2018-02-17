/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.factory;

import br.net.gvt.efika.customer.model.certification.CertificationAssert;
import br.net.gvt.efika.customer.model.certification.enums.CertificationAssertName;
import br.net.gvt.efika.customer.model.certification.enums.CertificationResult;



/**
 *
 * @author G0041775
 */
public class FactoryCertificationAssert {

    public static CertificationAssert createAssertByName(CertificationAssertName nome, CertificationResult resultado, String orientacao) {
        return new CertificationAssert(nome, resultado, orientacao);
    }

}
