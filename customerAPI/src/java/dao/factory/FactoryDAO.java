/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.http.HttpDAO;
import dao.http.HttpDAOImpl;
import dao.queue.QueueTaskDAO;
import dao.queue.QueueTaskDAOImpl;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static QueueTaskDAO createQueueTaskDAO() {
        return new QueueTaskDAOImpl();
    }
    
    public static HttpDAO createHttpDAO(){
        return new HttpDAOImpl();
    }

}
