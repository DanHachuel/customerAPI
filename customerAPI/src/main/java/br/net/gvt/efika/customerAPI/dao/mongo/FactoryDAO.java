/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.mongo;

import br.net.gvt.efika.customerAPI.dao.certification.CertificationDAO;
import br.net.gvt.efika.customerAPI.dao.certification.CertificationDAOImpl;
import br.net.gvt.efika.customerAPI.dao.exception.ExceptionLogDAOImpl;
import br.net.gvt.efika.customerAPI.model.entity.ExceptionLog;
import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static AbstractMongoDAO<ExceptionLog> newExceptionLogDAO() {
        return new ExceptionLogDAOImpl();
    }

    public static CertificationDAO newCertificationDAO() {
        return new CertificationDAOImpl();
    }

}
