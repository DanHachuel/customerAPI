/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.requests;

import io.swagger.model.GenericRequest;

/**
 *
 * @author G0041775
 */
public class RequestFactory {
    
    public static CustomerRequest customerRequest(GenericRequest gen){
        return new CustomerRequest(gen);
    }
    
}
