/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import br.net.gvt.efika.customer.EfikaCustomer;
import model.service.certification.impl.CertificationBlock;
import model.service.certification.enums.CertificationBlockName;

/**
 *
 * @author G0041775
 */
public interface BlockCertifier {

    public CertificationBlock certify(CertificationBlockName name, EfikaCustomer ec) throws Exception;

}
