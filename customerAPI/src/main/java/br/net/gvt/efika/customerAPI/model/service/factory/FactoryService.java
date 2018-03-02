/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.factory;

import br.net.gvt.efika.customerAPI.model.service.finder.CustomerFinder;
import br.net.gvt.efika.customerAPI.model.service.finder.CustomerFinderImpl;
import br.net.gvt.efika.customerAPI.model.service.certification.impl.CertificationServiceImpl;
import br.net.gvt.efika.customerAPI.model.service.certification.impl.CertificationService;
import br.net.gvt.efika.customerAPI.model.service.customer.EfikaCustomerService;
import br.net.gvt.efika.customerAPI.model.service.customer.EfikaCustomerServiceImpl;

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

    public static EfikaCustomerService createEfikaCustomerService() throws Exception {
        return new EfikaCustomerServiceImpl();
    }

}
