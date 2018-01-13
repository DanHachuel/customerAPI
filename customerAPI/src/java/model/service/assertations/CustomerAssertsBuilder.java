/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import br.net.gvt.efika.customer.CustomerAssert;
import fulltest.FullTest;
import java.util.List;

/**
 *
 * @author G0041775
 */
public interface CustomerAssertsBuilder {

    public List<CustomerAssert> buildAsserts(FullTest ft) throws Exception;

}
