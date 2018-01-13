/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.http.HttpDAO;
import dao.http.HttpDAOImpl;
import dao.log.CertificationLogDAO;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static HttpDAO createHttpDAO() {
        return new HttpDAOImpl();
    }

    public static CertificationLogDAO createCertificationLogDAO() {
        return new CertificationLogDAO();
    }
}
