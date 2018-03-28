/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certificator;

import br.net.gvt.efika.customerAPI.model.entity.CustomerCertification;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0041775
 */
public class FkIdGeneratorIT {
    
    public FkIdGeneratorIT() {
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
     * Test of generate method, of class FkIdGenerator.
     */
    @Test
    public void testGenerate() {
        System.out.println("generate");
        CustomerCertification certification = new CustomerCertification();
        EfikaCustomer c = new EfikaCustomer();
        c.setInstancia("4130157784");
        certification.setCustomer(c);
        FkIdGenerator instance = new FkIdGenerator();
        String result = instance.generate(certification);
        System.out.println(result);
    }
    
}
