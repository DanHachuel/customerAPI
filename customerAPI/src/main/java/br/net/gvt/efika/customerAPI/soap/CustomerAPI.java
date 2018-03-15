/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.soap;

import br.net.gvt.efika.customer.model.dto.GenericRequest;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import javax.jws.WebMethod;
import javax.jws.WebService;
import br.net.gvt.efika.customerAPI.model.entity.CustomerCertification;
import br.net.gvt.efika.customerAPI.model.service.factory.FactoryService;
import javax.validation.Valid;

/**
 *
 * @author G0042204
 */
@WebService(serviceName = "customerService", portName = "8080", targetNamespace = "http://efika/fulltest/")
public class CustomerAPI {

    @WebMethod(operationName = "certification")
    public CustomerCertification certification(@Valid GenericRequest body) throws Exception {
        try {
            return FactoryService.certSrvc().certificationByParam(body);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @WebMethod(operationName = "getCadastro")
    public EfikaCustomer getCadastro(@Valid GenericRequest body) throws Exception {
        try {
            return FactoryService.customerFinder().getCustomer(body);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
