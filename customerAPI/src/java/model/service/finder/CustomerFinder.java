/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.finder;

import br.net.gvt.efika.customer.EfikaCustomer;
import io.swagger.model.GenericRequest;

/**
 *
 * @author G0041775
 */
public interface CustomerFinder {

    public EfikaCustomer getCustomer(GenericRequest req) throws Exception;

}
