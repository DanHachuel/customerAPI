/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.queue.QueueDAOImpl;
import java.util.ArrayList;
import java.util.List;
import model.domain.queue.dto.QueueTaskDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.JacksonMapper;

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
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testConsumePendingTasks() throws Exception {
        JacksonMapper<List<QueueTaskDTO>> mapper = new JacksonMapper(new ArrayList<>().getClass());
        System.out.println("consumePendingTasks");
        QueueDAOImpl instance = new QueueDAOImpl();
        List<QueueTaskDTO> result = instance.consumePendingTasks();
        System.out.println(mapper.serialize(result));
        assertTrue(!result.isEmpty());
    }

}
