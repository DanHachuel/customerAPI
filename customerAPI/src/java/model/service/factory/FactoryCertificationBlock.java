/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.factory;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.enums.OrigemPlanta;
import model.service.certification.impl.cadastro.CadastroCertificationVIVO1Impl;
import model.service.certification.impl.cadastro.CadastroCertificationVIVO2Impl;
import model.service.certification.impl.CertificationBlock;
import model.service.certification.enums.CertificationBlockName;

/**
 *
 * @author G0041775
 */
public class FactoryCertificationBlock {

    public static CertificationBlock createBlockByName(CertificationBlockName name, EfikaCustomer ec) throws Exception {
        if (name == CertificationBlockName.CADASTRO) {
            return ec.getRede().getPlanta() == OrigemPlanta.VIVO2 ? new CadastroCertificationVIVO2Impl() : new CadastroCertificationVIVO1Impl();
        } else if (name == CertificationBlockName.CONECTIVIDADE) {

        }
        throw new Exception("Bloco de Certificação não implementado.");
    }

}
