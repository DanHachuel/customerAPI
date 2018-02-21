/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certification.impl;

import br.net.gvt.efika.customer.model.certification.enums.CertificationResult;
import br.net.gvt.efika.customerAPI.model.entity.CustomerCertification;
import br.net.gvt.efika.customerAPI.model.GenericRequest;
import br.net.gvt.efika.fulltest.model.fulltest.ValidacaoResult;
import br.net.gvt.efika.util.json.JacksonMapper;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0041775
 */
public class CertificationServiceImplIT {

    public CertificationServiceImplIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of fulltestByParam method, of class CertificationServiceImpl.
     */
    @Test
    public void testCertificationByParam() throws Exception {
        try {
            System.out.println("certificationByParam");
            GenericRequest req = new GenericRequest("4130886762", "G0042204");
            CertificationServiceImpl instance = new CertificationServiceImpl();
            CustomerCertification result = instance.certificationByParam(req);
            System.out.println(new JacksonMapper(CustomerCertification.class).serialize(result));
            assertTrue(result.getResultado() == CertificationResult.OK);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

    /**
     * Test of certifyRede method, of class CertificationServiceImpl.
     */
    @Test
    public void testCertifyRede() throws Exception {
        System.out.println("certifyRede");
        GenericRequest req = new GenericRequest("4133335556", "G0041775");
        CertificationServiceImpl instance = new CertificationServiceImpl();
        ValidacaoResult result = instance.certifyRede(req);
        System.out.println(new JacksonMapper(ValidacaoResult.class).serialize(result));
        
    }

}
