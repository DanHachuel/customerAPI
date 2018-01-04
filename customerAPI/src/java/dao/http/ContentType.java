/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.http;

/**
 *
 * @author G0041775
 */
public enum ContentType {

    JSON("application/json"),
    XML("application/xml");

    private final String valor;

    private ContentType(String cont) {
        valor = cont;
    }

    public String getCont() {
        return valor;
    }

    public String getValor() {
        return valor;
    }

    public static ContentType find(String cont) {
        return ContentType.valueOf(cont);
    }

}
