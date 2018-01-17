/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.command;

import model.entity.CustomerCertification;

/**
 *
 * @author G0042204
 */
public abstract class LogCommand implements Runnable {

    private CustomerCertification cert;

    public LogCommand(CustomerCertification cert) {
        this.cert = cert;
    }

    public CustomerCertification getCert() {
        return cert;
    }

    public void setCert(CustomerCertification cert) {
        this.cert = cert;
    }

}
