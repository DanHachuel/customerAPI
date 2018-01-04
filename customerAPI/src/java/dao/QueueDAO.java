/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.domain.queue.QueueTaskDTO;

/**
 *
 * @author G0042204
 */
public interface QueueDAO {

    public List<QueueTaskDTO> consumePendingTasks() throws Exception;

}
