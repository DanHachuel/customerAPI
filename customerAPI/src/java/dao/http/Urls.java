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
public enum Urls {

    CADASTRO_STEALER("http://10.40.195.81:8080/stealerAPI/oss/"),
    FULLTEST("http://10.40.195.81:8080/fulltestAPI/fulltest/co"),
    QUEUE("http://localhost:8080/queueAPI/queue/");

    private final String valor;

    private Urls(String url) {
        valor = url;
    }

    public String getUrl() {
        return valor;
    }

    public String getValor() {
        return valor;
    }

    public static Urls find(String url) {
        return Urls.valueOf(url);
    }

}
