/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl;

import fulltest.ValidacaoResult;
import telecom.properties.gpon.SerialOntGpon;
import br.net.gvt.efika.customer.EfikaCustomer;
import model.entity.CustomerCertification;
import io.swagger.model.GenericRequest;
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
