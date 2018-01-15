/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import fulltest.FullTest;
import model.entity.CertificationAssert;
import model.entity.enums.CertificationAssertName;
import model.factory.FactoryCertificationAssert;

public class CertificationAsserterImpl implements CertificationAsserter {

    @Override
    public CertificationAssert assertCertification(CertificationAssertName name) throws Exception {
        CertificationAssert retorno = FactoryCertificationAssert.createAssertByName(name);
        switch (name) {
            case HAS_BLOQ_INVENTARIO:
                break;
            case HAS_BLOQ_RADIUS:
                break;
            case HAS_MAC_DSLAM:
                break;
            case IS_ADM_UP:
                break;
            case IS_AUTH_OK:
                break;
            case IS_LINHA_CONF_PADRAO_OK:
                break;
            case IS_LINHA_SWITCH_OK:
                break;
            case IS_MODEM_ACTIVE:
                break;
            case IS_MODUL_OK:
                break;
            case IS_ONT_ASSOC:
                break;
            case IS_OPER_UP:
                break;
            case IS_PARAM_OK:
                break;
            case IS_PROFILE_OK:
                break;
            case IS_REDE_BANDA_OK:
                break;
            case IS_REDE_TV_OK:
                break;
            case IS_TBS_EQUALS_RADIUS:
                break;
            case IS_VIZINHO_OK:
                break;
            case IS_VLANS_OK:
                break;
            default:
                break;
        }

        return retorno;
    }

}
