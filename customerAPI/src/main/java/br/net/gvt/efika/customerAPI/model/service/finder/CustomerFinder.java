/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.finder;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.model.GenericRequest;

/**
 *
 * @author G0041775
 */
public interface CustomerFinder {

    public EfikaCustomer getCustomer(GenericRequest req) throws Exception;

}
