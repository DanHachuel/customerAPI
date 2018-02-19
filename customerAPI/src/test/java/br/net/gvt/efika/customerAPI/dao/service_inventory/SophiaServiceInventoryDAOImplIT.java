/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.service_inventory;

import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customer.model.customer.enums.OrigemInventarioServico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class SophiaServiceInventoryDAOImplIT {

    public SophiaServiceInventoryDAOImplIT() {
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
     * Test of consultar method, of class SophiaServiceInventoryDAOImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        String instancia = "4130886762";
        SophiaServiceInventoryDAOImpl instance = new SophiaServiceInventoryDAOImpl();
        EfikaCustomer result = instance.consultar(instancia);
        assertTrue("inventário", result.getInstancia() != null);
        assertTrue("inventário é sophia", result.getServicos().getOrigem() == OrigemInventarioServico.SOPHIA);
        System.out.println("end");
    }

}
