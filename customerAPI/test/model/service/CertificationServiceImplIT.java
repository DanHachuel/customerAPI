/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.service.certification.CertificationServiceImpl;
import fulltest.FullTest;
import io.swagger.model.GenericRequest;
import model.entity.CustomerLogCertification;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.JacksonMapper;

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
    public void testFulltestByParam() throws Exception {
        System.out.println("fulltestByParam");
        GenericRequest req = new GenericRequest("4130157784", "G0041775");
        CertificationServiceImpl instance = new CertificationServiceImpl();
        CustomerLogCertification result = instance.certificationByParam(req);
        System.out.println(new JacksonMapper(CustomerLogCertification.class).serialize(result));
    }

}
