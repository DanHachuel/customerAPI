/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.log;

import dao.AbstractMongoDAO;
import model.entity.CustomerCertification;

/**
 *
 * @author G0041775
 */
public class CertificationDAO extends AbstractMongoDAO<CustomerCertification> {

    public CertificationDAO() {
        super("10.40.197.137", "customerAPI", CustomerCertification.class);
    }

}
