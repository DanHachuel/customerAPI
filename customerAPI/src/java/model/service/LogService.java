/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.entity.CustomerLog;

/**
 *
 * @author G0041775
 */
public interface LogService<T> {

    public void salvaLog(T t) throws Exception;
    
}
