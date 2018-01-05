/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import io.swagger.model.GenericRequest;
import model.service.entity.fulltest.FullTest;

/**
 *
 * @author G0042204
 */
public interface CertificationService {

    public FullTest fulltestByParam(GenericRequest req) throws Exception;
    
}
