/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import br.net.gvt.efika.asserts.AssertsEnum;
import br.net.gvt.efika.customer.EfikaCustomer;
import model.service.assertations.exception.AssertNaoImpl;
import model.enums.CertificationAssertName;
import model.enums.CertificationResult;
import model.entity.CertificationAssert;
import model.service.certification.filters.CustomerAssertFilter;

public class CustomerCertificationAsserter extends CertificationAsserterAbs<EfikaCustomer> {

    @Override
    public CertificationAssert assertCertification(CertificationAssertName name, EfikaCustomer cust) throws Exception {
        certName = name;
        switch (name) {
            case HAS_BLOQ_INVENTARIO:
                // to do
                break;
            case HAS_BLOQ_RADIUS:
                if (!CustomerAssertFilter.getAssertByEnum(cust.getAsserts(), AssertsEnum.HAS_BLOQUEIO_RADIUS).getValue()) {
                    result = CertificationResult.OK;
                    orientacao = "Não há bloqueio no Radius.";
                } else {
                    result = CertificationResult.FORWARDED_CO;
                    orientacao = "Há bloqueio no Radius.";
                }
                break;
            case HAS_INV_REDE:

                if (cust.getRede().getIpDslam() == null) {
                    result = CertificationResult.FORWARDED_CO;
                    orientacao = "Acionar célula de Cadastro.";
                } else {
                    result = CertificationResult.OK;
                    orientacao = "Inventário de Rede OK.";
                }

                break;

            case HAS_INV_SERV:

                if (cust.getServicos().getVelDown() == null || cust.getServicos().getVelUp() == null){
                    result = CertificationResult.FORWARDED_CO;
                    orientacao = "Falha ao identificar serviços contratados.";
                } else {
                    result = CertificationResult.OK;
                    orientacao = "Inventário de Rede OK.";
                }

                break;
            case IS_INV_REDE_EQUALS_RADIUS:
                if (!CustomerAssertFilter.getAssertByEnum(cust.getAsserts(), AssertsEnum.DIVERGENCIA_TBS_RADIUS).getValue()) {
                    result = CertificationResult.OK;
                    orientacao = "Radius e Inventário de Rede OK.";
                } else {
                    result = CertificationResult.FORWARDED_CO;
                    orientacao = "Radius divergente do Inventário de Rede.";
                }
                break;

            default:
                throw new AssertNaoImpl();
        }

        return new CertificationAssert(certName, result, orientacao);
    }

}
