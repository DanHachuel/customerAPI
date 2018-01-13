/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.log;

import dao.AbstractMongoDAO;
import model.entity.CustomerLogCertification;

/**
 *
 * @author G0041775
 */
public class CertificationLogDAO extends AbstractMongoDAO<CustomerLogCertification> {

    public CertificationLogDAO() {
        super("10.40.197.137", "customerAPI", CustomerLogCertification.class);
    }

}
