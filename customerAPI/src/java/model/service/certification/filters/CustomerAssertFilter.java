/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.filters;

import br.net.gvt.efika.asserts.AssertsEnum;
import br.net.gvt.efika.customer.CustomerAssert;
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
