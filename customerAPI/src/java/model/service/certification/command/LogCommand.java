/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.command;

import model.entity.CustomerLogCertification;

/**
 *
 * @author G0042204
 */
public abstract class LogCommand implements Runnable {

    private CustomerLogCertification log;

    public LogCommand(CustomerLogCertification log) {
        this.log = log;
    }

    public CustomerLogCertification getLog() {
        return log;
    }

}
