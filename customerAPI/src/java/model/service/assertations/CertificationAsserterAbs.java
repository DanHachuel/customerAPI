/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import br.net.gvt.efika.model.certification.enuns.CertificationAssertName;
import br.net.gvt.efika.model.certification.enuns.CertificationResult;



public abstract class CertificationAsserterAbs<T> implements CertificationAsserter<T> {

    protected transient CertificationAssertName certName;

    protected transient CertificationResult result;

    protected transient String orientacao;
}
