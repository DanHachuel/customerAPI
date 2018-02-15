/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.log;

import br.net.gvt.efika.customerAPI.model.entity.CustomerCertification;
import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;

/**
 *
 * @author G0041775
 */
public class CertificationDAO extends AbstractMongoDAO<CustomerCertification> {

    public CertificationDAO() {
        //10.40.197.137
        super("10.200.35.67", "customerAPI", CustomerCertification.class);
    }

}
