/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.customer;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class EfikaCustomerServiceV1ImplIT {
    
    public EfikaCustomerServiceV1ImplIT() {
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
     * Test of consultar method, of class EfikaCustomerServiceV1Impl.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        String instancia = "";
        EfikaCustomerServiceV1Impl instance = new EfikaCustomerServiceV1Impl();
        EfikaCustomer expResult = null;
        EfikaCustomer result = instance.consultar(instancia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
