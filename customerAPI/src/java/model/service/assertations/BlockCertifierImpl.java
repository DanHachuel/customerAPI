/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import fulltest.FullTest;
import model.entity.CertificationAssert;
import model.entity.CertificationBlock;
import model.entity.enums.CertificationBlockName;
import model.factory.FactoryCertificationBlock;

public class BlockCertifierImpl implements BlockCertifier {

    @Override
    public CertificationBlock certify(CertificationBlockName name, FullTest ft) throws Exception {
        CertificationBlock retorno = FactoryCertificationBlock.createBlockByName(name);
        switch(name){
            case CADASTRO:
                retorno.getAsserts().add(null);
                break;
            case CONECTIVIDADE:
                break;
            case PERFORMANCE:
                break;
            case SERVICOS:
                break;
            default:
                break;
        }
        return retorno;
    }

}
