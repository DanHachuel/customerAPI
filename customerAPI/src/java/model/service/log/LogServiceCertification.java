/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.log;

import dao.factory.FactoryDAO;
import dao.log.CertificationLogDAO;
import model.entity.CustomerLogCertification;

public class LogServiceCertification implements LogService<CustomerLogCertification> {

    private static final CertificationLogDAO dao = FactoryDAO.createCertificationLogDAO();
    
    @Override
    public void salvaLog(CustomerLogCertification log) throws Exception {
        dao.save(log);
    }
    
    

}
