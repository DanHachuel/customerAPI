/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.queue.service;

import dao.factory.FactoryDAO;
import dao.queue.QueueTaskDAO;
import model.entity.QueueTask;
import org.mongodb.morphia.query.UpdateOperations;

/**
 *
 * @author G0042204
 */
public abstract class AbstractQueueTaskService {

    private QueueTaskDAO dao;

    public QueueTaskDAO getDao() {
        if (dao == null) {
            dao = FactoryDAO.createQueueTaskDAO();
        }
        return dao;
    }

    protected UpdateOperations<QueueTask> oper() {
        return getDao().createUpdateOperations();
    }

}
