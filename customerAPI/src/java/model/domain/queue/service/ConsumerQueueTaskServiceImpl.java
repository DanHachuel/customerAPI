/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.queue.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.queue.enuns.TaskState;
import model.entity.QueueTask;

public class ConsumerQueueTaskServiceImpl extends AbstractQueueTaskService implements ConsumerQueueTaskService {

    private static final Logger LOG = Logger.getLogger(ConsumerQueueTaskServiceImpl.class.getName());

    @Override
    public List<QueueTask> consumePendingTasks(String consumer) throws Exception {
        List<QueueTask> pending = this.getPendingTasks();
        pending.forEach((t) -> {
            t.setState(TaskState.RUNNING);
            t.setDateConsumed(new Date());
            t.setConsumer(consumer);
            try {
                getDao().update(t, oper()
                        .set("state", t.getState())
                        .set("consumer", t.getConsumer())
                        .set("dateConsumed", t.getDateConsumed()));
            } catch (Exception e) {
                LOG.log(Level.WARNING, "Falha ao alterar: {0}", t.getId().toHexString());
            }
        });
        return pending;
    }

    @Override
    public void completeTask(QueueTask t) throws Exception {
        t.setDateQueueOut(new Date());
        t.setState(TaskState.EXECUTED);
        getDao().update(t, oper()
                .set("state", t.getState())
                .set("dateQueueOut", t.getDateQueueOut())
                .set("output", t.getOutput()));
    }

    @Override
    public List<QueueTask> getPendingTasks() throws Exception {
        return getDao().listByState(TaskState.PENDING);
    }

}
