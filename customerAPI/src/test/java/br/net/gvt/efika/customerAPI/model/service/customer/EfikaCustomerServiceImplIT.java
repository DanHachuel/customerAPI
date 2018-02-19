/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.customer;

import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.model.service.factory.FactoryService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class EfikaCustomerServiceImplIT {

    public EfikaCustomerServiceImplIT() {
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
     * Test of consultar method, of class EfikaCustomerServiceImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        try {
            System.out.println("consultar");
            String instancia = "4130886762";
            EfikaCustomerService instance = FactoryService.createEfikaCustomerService();
            EfikaCustomer result = instance.consultar(instancia);
            assertTrue("Identificação Serviços", result.getServicos() != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
