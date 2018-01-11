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
import dao.log.FulltestLogDAO;
import fulltest.FullTest;
import fulltest.FulltestRequest;
import io.swagger.model.GenericRequest;
import java.nio.charset.Charset;
import java.util.Calendar;
import model.entity.CustomerLogFulltest;
import model.entity.factory.FactoryEntitiy;
import util.JacksonMapper;

public class CertificationServiceImpl implements CertificationService {

    private final HttpDAO dao = FactoryDAO.createHttpDAO();
    private final FulltestLogDAO logDao = FactoryDAO.createFulltestLogDAO();
    private final CustomerFinder finder = FactoryService.customerFinder();

    @Override
    public FullTest fulltestByParam(GenericRequest req) throws Exception {
        EfikaCustomer cust = finder.getCustomer(req);
        JacksonMapper<FullTest> mapperFulltest = new JacksonMapper(FullTest.class);

        FullTest ret = mapperFulltest.deserialize(dao.post(Urls.FULLTEST.getUrl(),
                new FulltestRequest(cust, req.getExecutor()),
                ContentType.JSON.getCont(), Charset.forName("UTF-8")));

        CustomerLogFulltest log = FactoryEntitiy.createCustLogFulltest();
        log.setDataExecucao(Calendar.getInstance().getTime());
        log.setInput(req);
        log.setOutput(ret);
        FactoryService.logFulltest().salvaLog(log);

        return ret;
    }

}
