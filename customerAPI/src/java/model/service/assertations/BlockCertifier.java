/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import fulltest.FullTest;
import model.entity.CertificationBlock;
import model.entity.enums.CertificationBlockName;

/**
 *
 * @author G0041775
 */
public interface BlockCertifier {

    public CertificationBlock certify(CertificationBlockName name, FullTest ft) throws Exception;

}
