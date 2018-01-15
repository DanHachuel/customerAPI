/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import fulltest.FullTest;
import model.service.certification.enums.CertificationAssertName;
import model.service.certification.impl.CertificationAssert;

public class FulltestCertificationAsserter extends CertificationAsserterAbs<FullTest> {

    @Override
    public CertificationAssert assertCertification(CertificationAssertName name, FullTest ft) throws Exception {
        certName = name;
        switch (name) {
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
            case IS_VIZINHO_OK:
                break;
            case IS_VLANS_OK:
                break;
            default:
                break;
        }

        return new CertificationAssert(certName, result, orientacao);
    }

}
