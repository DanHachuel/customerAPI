/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certification.impl;

import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.model.entity.CustomerCertification;
import br.net.gvt.efika.customerAPI.model.GenericRequest;
import br.net.gvt.efika.fulltest.ValidacaoResult;
import br.net.gvt.efika.telecom.properties.gpon.SerialOntGpon;
import java.util.List;

/**
 *
 * @author G0042204
 */
public interface CertificationService {

    public CustomerCertification certificationByParam(GenericRequest req) throws Exception;

    public ValidacaoResult certifyRede(GenericRequest req) throws Exception;

    public List<SerialOntGpon> ontsDisp(GenericRequest req) throws Exception;

    public ValidacaoResult setOntToOlt(GenericRequest req) throws Exception;

    public List<CustomerCertification> findByCustomer(EfikaCustomer cust) throws Exception;

}
