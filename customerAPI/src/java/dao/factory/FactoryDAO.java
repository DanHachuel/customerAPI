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
import dao.certification.CertificationDAOImpl;
import dao.configporta.ConfigPortaDAO;
import dao.configporta.ConfigPortaDAOImpl;
import dao.exception.ExceptionLogDAOImpl;
import dao.fulltest.FulltestDAO;
import dao.fulltest.FulltestDAOImpl;
import fulltest.FullTest;
import fulltest.ValidacaoResult;
import java.nio.charset.Charset;
import java.util.List;
import model.entity.ExceptionLog;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static HttpDAO createHttpCertificationDAO() {
        return new HttpDAOGenericImpl<CustomerCertificationDTO>(CustomerCertificationDTO.class) {
            @Override
            public Charset getResponseCharset() {
                return Charset.forName("UTF-8");
            }
        };
    }

    public static HttpDAO createHttpValidacaoResultDAO() {
        return new HttpDAOGenericImpl<ValidacaoResult>(ValidacaoResult.class) {
            @Override
            public Charset getResponseCharset() {
                return Charset.forName("UTF-8");
            }
        };
    }

    public static HttpDAO createHttpListDAO() {
        return new HttpDAOGenericImpl<List>(List.class) {
            @Override
            public Charset getResponseCharset() {
                return Charset.forName("UTF-8");
            }

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

    public static CertificationDAOImpl createCertificationLogDAO() {
        return new CertificationDAOImpl();
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
