/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.command;

import dao.factory.FactoryDAO;
import model.entity.ExceptionLog;

/**
 *
 * @author G0042204
 */
public abstract class NonExceptionCommand {

    public NonExceptionCommand() {
        this.command();
    }

    public abstract void run() throws Exception;

    public final void command() {
        try {
            this.run();
        } catch (Exception ex) {
            try {
                FactoryDAO.newExceptionLogDAO().save(new ExceptionLog(ex));
            } catch (Exception e) {
            }
        }
    }

}
