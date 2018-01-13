/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification;

import io.swagger.model.GenericRequest;
import model.entity.CustomerLogCertification;

/**
 *
 * @author G0042204
 */
public interface CertificationService {

    public CustomerLogCertification certificationByParam(GenericRequest req) throws Exception;
    
}
