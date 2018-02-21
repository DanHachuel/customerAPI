/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.assertations;

import br.net.gvt.efika.customer.model.certification.CertificationAssert;
import br.net.gvt.efika.customer.model.certification.enums.CertificationAssertName;
import static br.net.gvt.efika.customer.model.certification.enums.CertificationAssertName.*;
import br.net.gvt.efika.customer.model.certification.enums.CertificationResult;
import br.net.gvt.efika.efika_customer.model.customer.enums.TecnologiaLinha;
import br.net.gvt.efika.efika_customer.model.customer.enums.TecnologiaTv;
import br.net.gvt.efika.customerAPI.model.service.assertations.exception.AssertNaoImpl;
import br.net.gvt.efika.customerAPI.model.service.certification.filters.ValidsFilter;
import br.net.gvt.efika.fulltest.model.fulltest.FullTest;
import br.net.gvt.efika.fulltest.model.fulltest.ValidacaoResult;
import br.net.gvt.efika.fulltest.model.telecom.properties.EstadoDaPorta;
import br.net.gvt.efika.fulltest.model.telecom.properties.TelecomPropertiesEnum;

public class FulltestCertificationAsserter extends CertificationAsserterAbs<FullTest> {

    private transient ValidacaoResult v;

    @Override
    public CertificationAssert assertCertification(CertificationAssertName name, FullTest ft) throws Exception {
        try {
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
                    orientacao = v.getMensagem();
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
                    result = v.getResultado() ? CertificationResult.OK : CertificationResult.FISICAL;
                    orientacao = v.getMensagem();
                    break;

                case IS_VIZINHO_OK:
                    v = ValidsFilter.getValidByName(ft.getValids(), "Afetação Vizinhança");
                    result = v.getResultado() ? CertificationResult.OK : CertificationResult.FORWARDED_CO;
                    orientacao = v.getMensagem();

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
                    throw new AssertNaoImpl();
            }
            return new CertificationAssert(certName, result, orientacao);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertNaoImpl();
        }
    }

    // ExceptionLog
}
