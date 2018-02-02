/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.fulltest;

import dao.factory.FactoryDAO;
import dao.http.Urlss;
import fulltest.FullTest;
import fulltest.FulltestRequest;

public class FulltestDAOImpl implements FulltestDAO {

    @Override
    public FullTest fulltest(FulltestRequest request) throws Exception {
        return (FullTest) FactoryDAO.createHttpFulltestDAO().post(Urlss.FULLTEST.getUrl(),
                new FulltestRequest(request.getCust(), request.getExecutor()));
    }

}
