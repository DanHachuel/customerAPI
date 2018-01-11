/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

/**
 *
 * @author G0041775
 */
public class FactoryService {

    public static CustomerFinder customerFinder() {
        return new CustomerFinderImpl();
    }

    public static CertificationService certSrvc() {
        return new CertificationServiceImpl();
    }

    public static LogService logFulltest() {
        return new LogServiceFullTest();
    }
}
