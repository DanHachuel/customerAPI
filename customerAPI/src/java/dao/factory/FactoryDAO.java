/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.model.certification.CustomerCertificationDTO;
import br.net.gvt.efika.util.dao.http.HttpDAO;
import br.net.gvt.efika.util.dao.http.HttpDAOGenericImpl;
import dao.AbstractMongoDAO;
import dao.configporta.ConfigPortaDAO;
import dao.configporta.ConfigPortaDAOImpl;
import dao.exception.ExceptionLogDAOImpl;
import dao.fulltest.FulltestDAO;
import dao.fulltest.FulltestDAOImpl;
import dao.log.CertificationDAO;
import fulltest.FullTest;
import fulltest.ValidacaoResult;
import model.entity.ExceptionLog;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static HttpDAO createHttpCertificationDAO() {
        return new HttpDAOGenericImpl<CustomerCertificationDTO>(CustomerCertificationDTO.class) {
        };
    }

    public static HttpDAO createHttpValidacaoResultDAO() {
        return new HttpDAOGenericImpl<ValidacaoResult>(ValidacaoResult.class) {
        };
    }

    public static HttpDAO createHttpFulltestDAO() {
        return new HttpDAOGenericImpl<FullTest>(FullTest.class) {
        };
    }

    public static HttpDAO createHttpCustomerDAO() {
        return new HttpDAOGenericImpl<EfikaCustomer>(EfikaCustomer.class) {
        };
    }

    public static CertificationDAO createCertificationLogDAO() {
        return new CertificationDAO();
    }

    public static FulltestDAO newFulltestDAO() {
        return new FulltestDAOImpl();
    }

    public static ConfigPortaDAO newConfigPortaDAO() {
        return new ConfigPortaDAOImpl();
    }

    public static AbstractMongoDAO<ExceptionLog> newExceptionLogDAO() {
        return new ExceptionLogDAOImpl();
    }

}
