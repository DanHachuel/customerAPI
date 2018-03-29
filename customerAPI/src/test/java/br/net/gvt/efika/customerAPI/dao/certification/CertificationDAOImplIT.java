/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.certification;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import java.util.List;
import br.net.gvt.efika.customerAPI.model.entity.CustomerCertification;
import br.net.gvt.efika.util.json.JacksonMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author g0042204
 */
public class CertificationDAOImplIT {

    public CertificationDAOImplIT() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
     * Test of findByCustomer method, of class CertificationDAOImpl.
     */
    @Test
    public void testFindByCustomer() {
        try {
            System.out.println("findByCustomer");
            EfikaCustomer cust = new EfikaCustomer();
            cust.setInstancia("4130157784");
            CertificationDAOImpl instance = new CertificationDAOImpl();
            List<CustomerCertification> result = instance.findByCustomer(cust);
            System.out.println(new JacksonMapper<>(List.class).serialize(result));
            assertFalse(result.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

    /**
     * Test of read method, of class CertificationDAOImpl.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        String id = "";
        CertificationDAOImpl instance = new CertificationDAOImpl();
        CustomerCertification expResult = null;
        CustomerCertification result = instance.read(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByFkId method, of class CertificationDAOImpl.
     */
    @Test
    public void testFindByFkId() throws Exception {
        System.out.println("findByFkId");
        String fkId = "";
        CertificationDAOImpl instance = new CertificationDAOImpl();
       
        CustomerCertification result = instance.findByFkId(fkId);
        System.out.println(new JacksonMapper(CustomerCertification.class).serialize(result));
    }

}
