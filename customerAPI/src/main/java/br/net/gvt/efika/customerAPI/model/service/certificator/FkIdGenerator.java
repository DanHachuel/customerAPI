/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certificator;

import br.net.gvt.efika.customer.model.certification.enums.CertificationResult;
import br.net.gvt.efika.customerAPI.dao.certification.CertificationDAO;
import br.net.gvt.efika.customerAPI.dao.mongo.FactoryDAO;
import br.net.gvt.efika.customerAPI.model.entity.CustomerCertification;
import br.net.gvt.efika.util.string.RandomString;

/**
 *
 * @author G0041775
 */
public class FkIdGenerator {

    public static String generate(CustomerCertification certification) {
        String leid;
        CertificationDAO dao = FactoryDAO.newCertificationDAO();
        while(dao.findByFkId(leid = generateId(certification))!=null){}
        return leid;
    }

    private static String generateId(CustomerCertification certification) {
        String random = new RandomString(6).nextString();
        StringBuilder res = new StringBuilder();
        res.append("FK-");
        if (certification != null && certification.getResultado() == CertificationResult.OK) {
            res.append("S");
        } else {
            res.append("F");
        }

        res.append(certification.getCustomer().getInstancia().substring(0, 2));
        res.append(random);
        return res.toString();
    }

}
