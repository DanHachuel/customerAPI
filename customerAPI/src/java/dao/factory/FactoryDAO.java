/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.AbstractMongoDAO;
import dao.exception.ExceptionLogDAOImpl;
import dao.fulltest.FulltestDAO;
import dao.fulltest.FulltestDAOImpl;
import dao.http.HttpDAO;
import dao.http.HttpDAOImpl;
import dao.certification.CertificationDAOImpl;
import model.entity.ExceptionLog;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static HttpDAO createHttpDAO() {
        return new HttpDAOImpl();
    }

    public static CertificationDAOImpl createCertificationLogDAO() {
        return new CertificationDAOImpl();
    }

    public static FulltestDAO newFulltestDAO() {
        return new FulltestDAOImpl();
    }

    public static AbstractMongoDAO<ExceptionLog> newExceptionLogDAO() {
        return new ExceptionLogDAOImpl();
    }

}
