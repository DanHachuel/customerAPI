/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.service.log.LogServiceCertification;
import model.service.log.LogService;
import model.service.finder.CustomerFinder;
import model.service.finder.CustomerFinderImpl;
import model.service.certification.CertificationServiceImpl;
import model.service.certification.CertificationService;

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

    public static LogService logCertification() {
        return new LogServiceCertification();
    }
}
