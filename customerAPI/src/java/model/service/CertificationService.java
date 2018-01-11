/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import fulltest.FullTest;
import io.swagger.model.GenericRequest;

/**
 *
 * @author G0042204
 */
public interface CertificationService {

    public FullTest fulltestByParam(GenericRequest req) throws Exception;
    
}
