/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import br.net.gvt.efika.customer.EfikaCustomer;
import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.HttpDAO;
import dao.http.Urls;
import io.swagger.model.GenericRequest;
import model.entity.fulltest.FulltestRequest;
import model.service.entity.fulltest.FullTest;
import util.JacksonMapper;

public class CertificationServiceImpl implements CertificationService {

    private final HttpDAO dao = FactoryDAO.createHttpDAO();
    private final CustomerFinder finder = FactoryService.customerFinder();

    @Override
    public FullTest fulltestByParam(GenericRequest req) throws Exception {
        EfikaCustomer cust = finder.getCustomer(req);
        JacksonMapper<FullTest> mapperFulltest = new JacksonMapper(FullTest.class);

        return mapperFulltest.deserialize(dao.post(Urls.FULLTEST.getUrl(),
                new FulltestRequest(cust, req.getExecutor()),
                ContentType.JSON.getCont()));
    }

}
