/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.request;

import io.swagger.model.GenericRequest;

/**
 *
 * @author G0041775
 */
public class CustomerRequest {

    private String executor;

    private String instancia;

    public CustomerRequest() {
    }

    public CustomerRequest(GenericRequest gen) {
        this.executor = gen.getExecutor();
        this.instancia = gen.getParameter();
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

}
