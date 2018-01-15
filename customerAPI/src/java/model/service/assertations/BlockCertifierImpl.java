/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import br.net.gvt.efika.customer.EfikaCustomer;
import model.service.certification.impl.CertificationBlock;
import model.service.certification.enums.CertificationBlockName;

public class BlockCertifierImpl implements BlockCertifier {

    @Override
    public CertificationBlock certify(CertificationBlockName name, EfikaCustomer ec) throws Exception {
//        switch (name) {
//            case CADASTRO:
//                retorno.getAsserts().add(null);
//                break;
//            case CONECTIVIDADE:
//                break;
//            case PERFORMANCE:
//                break;
//            case SERVICOS:
//                break;
//            default:
//                break;
//        }
        return null;
    }

}
