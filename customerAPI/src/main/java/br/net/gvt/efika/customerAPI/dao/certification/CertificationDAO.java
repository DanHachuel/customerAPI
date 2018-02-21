/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.certification;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import java.util.List;
import br.net.gvt.efika.customerAPI.model.entity.CustomerCertification;

/**
 *
 * @author g0042204
 */
public interface CertificationDAO {

    public List<CustomerCertification> findByCustomer(EfikaCustomer cust) throws Exception;

    public CustomerCertification save(CustomerCertification cert) throws Exception;

    public CustomerCertification read(String id) throws Exception;

}
