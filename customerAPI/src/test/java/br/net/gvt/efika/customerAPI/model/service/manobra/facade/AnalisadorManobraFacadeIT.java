/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.manobra.facade;

import br.net.gvt.efika.customer.model.manobra.enums.ConclusaoManobraEnum;
import br.net.gvt.efika.customerAPI.model.service.manobra.analitcs.AnaliseMotivo;
import br.net.gvt.efika.customerAPI.model.service.manobra.analitcs.FinalizacaoManobra;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class AnalisadorManobraFacadeIT {

    public AnalisadorManobraFacadeIT() {
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
     * Test of analisar method, of class AnalisadorManobraFacade.
     */
    @Test
    public void testAnalisar() {
        System.out.println("analisar");
        AnalisadorManobraFacade instance = null;
        FinalizacaoManobra expResult = null;
        FinalizacaoManobra result = instance.analisar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class AnalisadorManobraFacade.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        AnalisadorManobraFacade instance = null;
        List<AnaliseMotivo> expResult = null;
        List<AnaliseMotivo> result = instance.run();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processar method, of class AnalisadorManobraFacade.
     */
    @Test
    public void testProcessar() {
        System.out.println("processar");
        List<AnaliseMotivo> an = null;
        AnalisadorManobraFacade instance = null;
        AnaliseMotivo expResult = null;
        AnaliseMotivo result = instance.processar(an);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarNecessidadeManobra method, of class
     * AnalisadorManobraFacade.
     */
    @Test
    public void testVerificarNecessidadeManobra() {
        System.out.println("verificarNecessidadeManobra");
        ConclusaoManobraEnum c = null;
        AnalisadorManobraFacade instance = null;
        Boolean expResult = null;
        Boolean result = instance.verificarNecessidadeManobra(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
