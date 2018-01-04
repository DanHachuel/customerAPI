/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.domain.queue.Item;
import model.domain.queue.enuns.TaskState;
import model.domain.queue.enuns.TasksEnum;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author G0042204
 */
@Entity("queue_task")
public class QueueTask extends AbstractMongoEntity {

    private Date dateQueueIn;

    private Date dateConsumed;

    private Date dateQueueOut;

    private TaskState state;

    private TasksEnum task;

    private List<Item> input;

    private String executor;

    private String consumer;

    private Object output;

    public QueueTask() {
    }

    public Date getDateQueueIn() {
        return dateQueueIn;
    }

    public void setDateQueueIn(Date dateQueueIn) {
        this.dateQueueIn = dateQueueIn;
    }

    public Date getDateQueueOut() {
        return dateQueueOut;
    }

    public void setDateQueueOut(Date dateQueueOut) {
        this.dateQueueOut = dateQueueOut;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public TasksEnum getTask() {
        return task;
    }

    public void setTask(TasksEnum task) {
        this.task = task;
    }

    public List<Item> getInput() {
        if (input == null) {
            input = new ArrayList<>();
        }
        return input;
    }

    public void addInputItem(Item item) {
        this.getInput().add(item);
    }

    public void setInput(List<Item> input) {
        this.input = input;
    }

    public void setOutput(Object output) {
        this.output = output;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public Date getDateConsumed() {
        return dateConsumed;
    }

    public void setDateConsumed(Date dateConsumed) {
        this.dateConsumed = dateConsumed;
    }

    public Object getOutput() {
        return output;
    }

}
