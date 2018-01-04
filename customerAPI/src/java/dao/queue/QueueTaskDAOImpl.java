/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.queue;

import dao.AbstractMongoDAO;
import java.util.List;
import model.domain.queue.enuns.TaskState;
import model.entity.QueueTask;
import org.mongodb.morphia.query.UpdateOperations;

/**
 *
 * @author G0042204
 */
public class QueueTaskDAOImpl extends AbstractMongoDAO<QueueTask> implements QueueTaskDAO {

    public QueueTaskDAOImpl() {
        super("10.40.197.137", "queueAPI", QueueTask.class);
    }

    @Override
    public List<QueueTask> listByState(TaskState state) throws Exception {
        return getDatastore().createQuery(QueueTask.class).field("state").equal(state).asList();
    }

    @Override
    public QueueTask update(QueueTask t, UpdateOperations<QueueTask> opers) throws Exception {
        getDatastore().update(t, opers);
        return t;
    }

}
