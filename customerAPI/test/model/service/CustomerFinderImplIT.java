/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import br.net.gvt.efika.customer.EfikaCustomer;
import io.swagger.model.GenericRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.GsonUtil;

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
        GenericRequest req = new GenericRequest();
        req.setExecutor("G0041775");
        req.setParameter("4133335556");
        CustomerFinderImpl instance = new CustomerFinderImpl();
        EfikaCustomer result = instance.getCustomer(req);
        System.out.println(GsonUtil.serialize(result));
        
    }
    
}
