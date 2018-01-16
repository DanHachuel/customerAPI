/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import br.net.gvt.efika.enums.TecnologiaLinha;
import br.net.gvt.efika.enums.TecnologiaTv;
import fulltest.FullTest;
import fulltest.ValidacaoResult;
import model.service.certification.enums.CertificationAssertName;
import model.service.certification.enums.CertificationResult;
import model.service.certification.impl.CertificationAssert;
import model.service.certification.filters.ValidsFilter;
import telecom.properties.EstadoDaPorta;
import telecom.properties.TelecomPropertiesEnum;

public class FulltestCertificationAsserter extends CertificationAsserterAbs<FullTest> {

    private transient ValidacaoResult v;

    @Override
    public CertificationAssert assertCertification(CertificationAssertName name, FullTest ft) throws Exception {
        certName = name;
        switch (name) {
            case HAS_MAC_DSLAM:
                v = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.DeviceMAC);
                orientacao = v.getMensagem();
                result = v.getResultado() ? CertificationResult.OK : CertificationResult.FISICAL;

                break;

            case IS_ADM_UP:
                v = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.EstadoDaPorta);
                orientacao = v.getMensagem();
                if (v.getFoiCorrigido()) {
                    result = CertificationResult.FIXED;
                } else {
                    result = v.getResultado() ? CertificationResult.OK : CertificationResult.FORWARDED_CO;
                }

                break;

            case IS_AUTH_OK:

                //to do
                break;
            case IS_LINHA_CONF_PADRAO_OK:

                //to do
                break;
            case IS_LINHA_SWITCH_OK:

                //to do
                break;
            case IS_MODEM_ACTIVE:

                //to do
                break;
            case IS_MODUL_OK:
                v = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.Modulacao);
                orientacao = v.getMensagem();
                if (v.getFoiCorrigido()) {
                    result = CertificationResult.FIXED;
                } else {
                    result = v.getResultado() ? CertificationResult.OK : CertificationResult.FORWARDED_CO;
                }
                break;
            case IS_ONT_ASSOC:
                v = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.SerialOntGpon);
                orientacao = v.getMensagem();
                if (v.getFoiCorrigido()) {
                    result = CertificationResult.FIXED;
                } else {
                    result = v.getResultado() ? CertificationResult.OK : CertificationResult.TO_FIX;
                }
                break;

            case IS_OPER_UP:
                v = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.EstadoDaPorta);
                EstadoDaPorta ep = (EstadoDaPorta) v.getResult();
                result = ep.getOperState() ? CertificationResult.OK : CertificationResult.FISICAL;
                orientacao = ep.getOperState() ? "Sincronismo/Link OK." : "Sem sincronismo/link.";
                break;

            case IS_PARAM_OK:
                ValidacaoResult valid = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.TabelaParametrosGpon);
                v = valid == null ? ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.TabelaParametrosMetalico) : valid;
                result = v.getResultado() ? CertificationResult.OK : CertificationResult.FISICAL;
                break;

            case IS_PROFILE_OK:
                v = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.Profile);
                orientacao = v.getMensagem();
                if (v.getFoiCorrigido()) {
                    result = CertificationResult.FIXED;
                } else {
                    result = v.getResultado() ? CertificationResult.OK : CertificationResult.FORWARDED_CO;
                }
                break;

            case IS_REDE_BANDA_OK:
                v = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.TabelaRedeMetalico);
                if (v.getFoiCorrigido()) {
                    result = CertificationResult.TO_FIX;
                } else {
                    result = v.getResultado() ? CertificationResult.OK : CertificationResult.FISICAL;
                }
                break;
            case IS_REDE_TV_OK:

                //to do
                break;

            case IS_VIZINHO_OK:

                //to do
                break;
            case IS_VLANS_OK:
                v = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.VlanBanda);
                orientacao = v.getMensagem();
                if (v.getFoiCorrigido()) {
                    result = CertificationResult.FIXED;
                } else {
                    result = v.getResultado() ? CertificationResult.OK : CertificationResult.FORWARDED_CO;
                }
                if (ft.getCl().getServicos().getTipoLinha() == TecnologiaLinha.SIP) {
                    v = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.VlanVoip);
                    orientacao += "\n" + v.getMensagem();
                    if (v.getFoiCorrigido()) {
                        result = CertificationResult.FIXED;
                    } else {
                        result = v.getResultado() ? CertificationResult.OK : CertificationResult.FORWARDED_CO;
                    }
                }
                if (ft.getCl().getServicos().getTipoTv() != null) {
                    if (ft.getCl().getServicos().getTipoTv() != TecnologiaTv.DTH) {
                        v = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.VlanVod);
                        orientacao += "\n" + v.getMensagem();
                        if (v.getFoiCorrigido()) {
                            result = CertificationResult.FIXED;
                        } else {
                            result = v.getResultado() ? CertificationResult.OK : CertificationResult.FORWARDED_CO;
                        }
                        v = ValidsFilter.getValidByEnum(ft.getValids(), TelecomPropertiesEnum.VlanMulticast);
                        orientacao += "\n" + v.getMensagem();
                        if (v.getFoiCorrigido()) {
                            result = CertificationResult.FIXED;
                        } else {
                            result = v.getResultado() ? CertificationResult.OK : CertificationResult.FORWARDED_CO;
                        }
                    }
                }
                break;
                
            default:
                break;
        }

        return new CertificationAssert(certName, result, orientacao);
    }

}
