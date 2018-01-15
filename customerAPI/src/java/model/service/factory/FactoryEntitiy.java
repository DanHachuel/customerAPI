package model.service.factory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.entity.CustomerLogCertification;

/**
 *
 * @author G0041775
 */
public class FactoryEntitiy {

    public static CustomerLogCertification createCustLogCertification() {
        return new CustomerLogCertification();
    }

}
