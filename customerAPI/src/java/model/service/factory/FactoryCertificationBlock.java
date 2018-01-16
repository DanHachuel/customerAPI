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
import model.service.certification.impl.conectividade.ConectividadeCertification;
import model.service.certification.impl.performance.PerformanceCertification;
import model.service.certification.impl.servicos.ServicosCertification;

/**
 *
 * @author G0041775
 */
public class FactoryCertificationBlock {

    public static CertificationBlock createBlockByName(CertificationBlockName name, EfikaCustomer ec) throws Exception {
        switch (name) {
            case CADASTRO:
                return ec.getRede().getPlanta() == OrigemPlanta.VIVO2 ? new CadastroCertificationVIVO2Impl() : new CadastroCertificationVIVO1Impl();
            case CONECTIVIDADE:
                return new ConectividadeCertification();
            case SERVICOS:
                return new ServicosCertification();
            case PERFORMANCE:
                return new PerformanceCertification();
            default:
                throw new Exception("Bloco de Certificação não implementado.");
        }
    }

}
