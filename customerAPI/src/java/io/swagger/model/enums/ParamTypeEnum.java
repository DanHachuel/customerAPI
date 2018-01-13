/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Tipo do parâmetro enviado
 */
public enum ParamTypeEnum {
    INSTANCIA("INSTANCIA"),
    WORKORDER_ID("WORKORDER_ID");
    private String value;

    ParamTypeEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }
}
