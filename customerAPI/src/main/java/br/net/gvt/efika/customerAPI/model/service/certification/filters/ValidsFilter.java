/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certification.filters;

import fulltest.ValidacaoResult;
import java.util.List;
import telecom.properties.TelecomPropertiesEnum;

public class ValidsFilter {

    public static ValidacaoResult getValidByEnum(List<ValidacaoResult> list, TelecomPropertiesEnum validName) {
        for (ValidacaoResult valid : list) {
            if (valid.getResult() != null) {
                if (TelecomPropertiesEnum.fromString(valid.getResult().getNome()) == validName) {
                    return valid;
                }
            }
        }
        return null;
    }

    public static ValidacaoResult getValidByName(List<ValidacaoResult> list, String validName) {
        for (ValidacaoResult valid : list) {
            if (valid.getNome().contentEquals(validName)) {
                return valid;
            }
        }
        return null;
    }
}
