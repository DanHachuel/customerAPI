/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.http;

import io.swagger.model.GenericRequest;
import model.requests.CustomerRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0041775
 */
public class HttpDAOImplIT {

    public HttpDAOImplIT() {
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
     * Test of get method, of class HttpDAOImpl.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        String url = "http://10.40.195.81:8080/networkInventoryAPI/networkInventory/4133335556";
        String contentType = "application/json";
        HttpDAOImpl instance = new HttpDAOImpl();

        String result = instance.get(url, contentType);
        System.out.println(result);
    }

    /**
     * Test of post method, of class HttpDAOImpl.
     */
    @Test
    public void testPost() throws Exception {
        System.out.println("post");
        String url = "http://10.40.195.81:8080/stealerAPI/oss/";
        CustomerRequest obj = new CustomerRequest();
        obj.setExecutor("G0041775");
        obj.setInstancia("4133335556");
        String contentType = "application/json";
        HttpDAOImpl instance = new HttpDAOImpl();
        String result = instance.post(url, obj, contentType);
        System.out.println(result);

    }

}
