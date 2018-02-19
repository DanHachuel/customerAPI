/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.finder;

import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.model.GenericRequest;
import br.net.gvt.efika.util.json.JacksonMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0041775
 */
public class CustomerFinderImplIT {

    public CustomerFinderImplIT() {
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
     * Test of getCustomer method, of class CustomerFinderImpl.
     */
    @Test
    public void testGetCustomer() throws Exception {
        System.out.println("getCustomer");
        JacksonMapper<GenericRequest> mapper = new JacksonMapper(GenericRequest.class);
        GenericRequest req = mapper.deserialize("{\"parameter\":\"1332321512\", \"executor\":\"G0041775\"}");

        CustomerFinderImpl instance = new CustomerFinderImpl();
        EfikaCustomer result = instance.getCustomer(req);
        System.out.println(new JacksonMapper(EfikaCustomer.class).serialize(result));

    }

}
