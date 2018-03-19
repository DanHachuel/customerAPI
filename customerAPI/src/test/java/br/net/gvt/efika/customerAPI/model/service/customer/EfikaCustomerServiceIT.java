/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.customer;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.util.json.JacksonMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class EfikaCustomerServiceIT {

    public EfikaCustomerServiceIT() {
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
     * Test of consultar method, of class EfikaCustomerService.
     */
    @Test
    public void testConsultarSophia() {
        try {
            System.out.println("testConsultarSophia");
            String instancia = "4130886762";
            EfikaCustomerService instance = new EfikaCustomerServiceV2Impl();
            EfikaCustomer result = instance.consultar(instancia);
            assertTrue(result.getRede() != null);
            System.out.println(new JacksonMapper(EfikaCustomer.class).serialize(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testConsultarSophiaMetalicoVivo1() {
        try {
            System.out.println("testConsultarSophiaMetalicoVivo1");
            String instancia = "4130886762";
            EfikaCustomerService instance = new EfikaCustomerServiceV2Impl();
            EfikaCustomer result = instance.consultar(instancia);
            assertTrue(result.getRede() != null);
            System.out.println(new JacksonMapper(EfikaCustomer.class).serialize(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
