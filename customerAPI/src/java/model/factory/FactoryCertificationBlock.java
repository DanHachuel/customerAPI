/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import model.entity.CertificationBlock;
import model.entity.enums.CertificationBlockName;

/**
 *
 * @author G0041775
 */
public class FactoryCertificationBlock {

    public static CertificationBlock createBlockByName(CertificationBlockName name) {
        return new CertificationBlock(name);
    }

}
