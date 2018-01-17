/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import model.entity.CertificationAssert;
import model.enums.CertificationAssertName;

/**
 *
 * @author G0041775
 */
public interface CertificationAsserter<T> {

    public CertificationAssert assertCertification(CertificationAssertName name, T t) throws Exception;

}
