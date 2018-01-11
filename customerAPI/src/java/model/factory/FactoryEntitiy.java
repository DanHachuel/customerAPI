/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity.factory;

import model.entity.CustomerLog;
import model.entity.CustomerLogFulltest;

/**
 *
 * @author G0041775
 */
public class FactoryEntitiy {

    public static CustomerLogFulltest createCustLogFulltest() {
        return new CustomerLogFulltest();
    }

}
