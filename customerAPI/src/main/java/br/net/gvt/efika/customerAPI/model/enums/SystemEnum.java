/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Sistema que originou a requisição
 */
public enum SystemEnum {
    URA("URA"),
    APP("APP"),
    CO("CO"),
    CRM("CRM");

    private String value;

    SystemEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }
}
