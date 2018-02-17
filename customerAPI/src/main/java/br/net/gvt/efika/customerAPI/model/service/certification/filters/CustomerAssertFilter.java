/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certification.filters;

import br.net.gvt.efika.customer.model.customer.CustomerAssert;
import br.net.gvt.efika.customer.model.customer.asserts.AssertsEnum;
import java.util.List;

public class CustomerAssertFilter {

    public static CustomerAssert getAssertByEnum(List<CustomerAssert> list, AssertsEnum assertEnum) {
        for (CustomerAssert customerAssert : list) {
            if (customerAssert.getAsserts() == assertEnum) {
                return customerAssert;
            }
        }
        return null;
    }

}
