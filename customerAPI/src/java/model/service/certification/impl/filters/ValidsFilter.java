/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl.filters;

import fulltest.ValidacaoResult;
import java.util.List;
import telecom.properties.TelecomPropertiesEnum;

public class ValidsFilter {

    public static ValidacaoResult getValidByEnum(List<ValidacaoResult> list, TelecomPropertiesEnum validName) {
        for (ValidacaoResult valid : list) {
            if (TelecomPropertiesEnum.find(valid.getResult().getNome()) == validName) {
                return valid;
            }
        }
        return null;
    }
}
