/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import dao.factory.FactoryDAO;
import dao.log.FulltestLogDAO;
import model.entity.CustomerLogFulltest;

public class LogServiceFullTest implements LogService<CustomerLogFulltest> {

    private static final FulltestLogDAO dao = FactoryDAO.createFulltestLogDAO();
    
    @Override
    public void salvaLog(CustomerLogFulltest log) throws Exception {
        dao.save(log);
    }

}
