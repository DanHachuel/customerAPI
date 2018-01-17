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
//            case HAS_MAC_DSLAM:
//                break;
//            case IS_ADM_UP:
//                break;
//            case IS_AUTH_OK:
//                break;
//            case IS_LINHA_CONF_PADRAO_OK:
//                break;
//            case IS_LINHA_SWITCH_OK:
//                break;
//            case IS_MODEM_ACTIVE:
//                break;
//            case IS_MODUL_OK:
//                break;
//            case IS_ONT_ASSOC:
//                break;
//            case IS_OPER_UP:
//                break;
//            case IS_PARAM_OK:
//                break;
//            case IS_PROFILE_OK:
//                break;
//            case IS_REDE_BANDA_OK:
//                break;
//            case IS_REDE_TV_OK:
//                break;
            case IS_INV_REDE_EQUALS_RADIUS:
                if (!CustomerAssertFilter.getAssertByEnum(cust.getAsserts(), AssertsEnum.DIVERGENCIA_TBS_RADIUS).getValue()) {
                    result = CertificationResult.OK;
                    orientacao = "Radius e Inventário de Rede OK.";
                } else {
                    result = CertificationResult.FORWARDED_CO;
                    orientacao = "Radius divergente do Inventário de Rede.";
                }
                break;
//            case IS_VIZINHO_OK:
//                break;
//            case IS_VLANS_OK:
//                break;
            default:
                throw new AssertNaoImpl();
        }

        return new CertificationAssert(certName, result, orientacao);
    }

}
