/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.queue;

import dao.GenericDAO;
import java.util.List;
import model.domain.queue.enuns.TaskState;
import model.entity.QueueTask;

/**
 *
 * @author G0042204
 */
public interface QueueTaskDAO extends GenericDAO<QueueTask> {

    public List<QueueTask> listByState(TaskState state) throws Exception;

}
