/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import br.net.gvt.efika.model.certification.CertificationAssert;
import br.net.gvt.efika.model.certification.enuns.CertificationAssertName;

/**
 *
 * @author G0041775
 * @param <T>
 */
public interface CertificationAsserter<T> {

    public CertificationAssert assertCertification(CertificationAssertName name, T t) throws Exception;

}
