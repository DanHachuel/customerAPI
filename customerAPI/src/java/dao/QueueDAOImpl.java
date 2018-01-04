/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.HttpDAO;
import dao.http.Urls;
import dao.request.RequestFactory;
import java.util.List;
import java.util.ArrayList;
import model.domain.queue.QueueTaskDTO;
import util.JacksonMapper;

public class QueueDAOImpl implements QueueDAO {

    private static final HttpDAO HTTP_DAO = FactoryDAO.createHttpDAO();

    @Override
    public List<QueueTaskDTO> consumePendingTasks() throws Exception {
        JacksonMapper<List<QueueTaskDTO>> mapper = new JacksonMapper(new ArrayList<QueueTaskDTO>().getClass());
        return mapper.deserialize(HTTP_DAO.post(
                Urls.QUEUE.getValor() + "consumePendingTasks",
                RequestFactory.queueRequest(),
                ContentType.JSON.getValor()));
    }

}
