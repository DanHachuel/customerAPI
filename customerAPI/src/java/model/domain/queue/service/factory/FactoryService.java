/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.queue.service.factory;

import model.domain.queue.service.ConsumerQueueTaskService;
import model.domain.queue.service.ConsumerQueueTaskServiceImpl;
import model.domain.queue.service.QueueTaskService;
import model.domain.queue.service.QueueTaskServiceImpl;

/**
 *
 * @author G0042204
 */
public class FactoryService {

    public static ConsumerQueueTaskService createConsumerQueueTaskService() {
        return new ConsumerQueueTaskServiceImpl();
    }

    public static QueueTaskService createQueueTaskService() {
        return new QueueTaskServiceImpl();
    }

}
