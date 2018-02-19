package br.net.gvt.efika.customerAPI.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customer.model.customer.InventarioRede;
import br.net.gvt.efika.util.json.JacksonMapper;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class JacksonMapperJUnitTest {

    public JacksonMapperJUnitTest() {
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

    @Test
    public void hello() {
        try {
            JacksonMapper<EfikaCustomer> map = new JacksonMapper<>(EfikaCustomer.class);
            EfikaCustomer obj = new EfikaCustomer();
            InventarioRede rede = new InventarioRede();
            rede.setCvlan(100);
            obj.setRede(rede);
            System.out.println(map.serialize(obj));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
}
