/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.fulltest;

import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.HttpDAO;
import dao.http.Urls;
import fulltest.FullTest;
import fulltest.FulltestRequest;
import java.nio.charset.Charset;
import util.JacksonMapper;

public class FulltestDAOImpl implements FulltestDAO {

    private final HttpDAO dao = FactoryDAO.createHttpDAO();

    @Override
    public FullTest fulltest(FulltestRequest request) throws Exception {
        JacksonMapper<FullTest> mapperFulltest = new JacksonMapper(FullTest.class);
        return mapperFulltest.deserialize(dao.post(Urls.FULLTEST.getUrl(),
                new FulltestRequest(request.getCust(), request.getExecutor()),
                ContentType.JSON.getCont(), Charset.forName("UTF-8")));
    }

}
