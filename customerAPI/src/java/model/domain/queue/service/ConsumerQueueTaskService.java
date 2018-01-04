/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.queue.service;

import java.util.List;
import model.entity.QueueTask;

/**
 *
 * @author G0042204
 */
public interface ConsumerQueueTaskService {

    public List<QueueTask> consumePendingTasks(String consumer) throws Exception;

    public void completeTask(QueueTask queueTask) throws Exception;

    public List<QueueTask> getPendingTasks() throws Exception;

}
