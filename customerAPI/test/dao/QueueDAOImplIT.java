/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.entity.QueueTask;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class QueueDAOImplIT {
    
    public QueueDAOImplIT() {
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
     * Test of consumePendingTasks method, of class QueueDAOImpl.
     */
    @Test
    public void testConsumePendingTasks() throws Exception {
        System.out.println("consumePendingTasks");
        QueueDAOImpl instance = new QueueDAOImpl();
        List<QueueTask> result = instance.consumePendingTasks();
        assertTrue(!result.isEmpty());
    }
    
}
