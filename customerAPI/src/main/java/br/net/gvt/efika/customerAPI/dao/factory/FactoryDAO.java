/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.factory;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.model.certification.CustomerCertificationDTO;
import br.net.gvt.efika.util.dao.http.HttpDAO;
import br.net.gvt.efika.util.dao.http.HttpDAOGenericImpl;
import br.net.gvt.efika.customerAPI.dao.certification.CertificationDAOImpl;
import br.net.gvt.efika.customerAPI.dao.configporta.ConfigPortaDAO;
import br.net.gvt.efika.customerAPI.dao.configporta.ConfigPortaDAOImpl;
import br.net.gvt.efika.customerAPI.dao.exception.ExceptionLogDAOImpl;
import br.net.gvt.efika.customerAPI.dao.fulltest.FulltestDAO;
import br.net.gvt.efika.customerAPI.dao.fulltest.FulltestDAOImpl;
import fulltest.FullTest;
import fulltest.ValidacaoResult;
import java.nio.charset.Charset;
import java.util.List;
import br.net.gvt.efika.customerAPI.model.entity.ExceptionLog;
import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;
import br.net.gvt.efika.util.dao.http.HttpDAOGenericNonProxyImpl;

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
        return new HttpDAOGenericNonProxyImpl<List>(List.class) {
            @Override
            public Charset getResponseCharset() {
                return Charset.forName("UTF-8");
            }
        };
    }

    public static HttpDAO createHttpFulltestDAO() {
        return new HttpDAOGenericNonProxyImpl<FullTest>(FullTest.class) {
            @Override
            public Charset getResponseCharset() {
                return Charset.forName("UTF-8");
            }
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
