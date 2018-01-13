/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification;

import br.net.gvt.efika.customer.EfikaCustomer;
import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.HttpDAO;
import dao.http.Urls;
import fulltest.FullTest;
import fulltest.FulltestRequest;
import io.swagger.model.GenericRequest;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.ResourceBundle;
import model.entity.CustomerLogCertification;
import model.factory.FactoryEntitiy;
import model.factory.FactoryLocale;
import model.service.finder.CustomerFinder;
import model.service.FactoryService;
import util.JacksonMapper;

public class CertificationServiceImpl implements CertificationService {
    
    private final HttpDAO dao = FactoryDAO.createHttpDAO();
    private final CustomerFinder finder = FactoryService.customerFinder();
    
    @Override
    public CustomerLogCertification certificationByParam(GenericRequest req) throws Exception {
        EfikaCustomer cust = finder.getCustomer(req);
        
        ResourceBundle bundle = ResourceBundle.getBundle("messages", FactoryLocale.createLocale(req.getSystem()));
        
        JacksonMapper<FullTest> mapperFulltest = new JacksonMapper(FullTest.class);
        FullTest ret = mapperFulltest.deserialize(dao.post(Urls.FULLTEST.getUrl(),
                new FulltestRequest(cust, req.getExecutor()),
                ContentType.JSON.getCont(), Charset.forName("UTF-8")));
        
        CustomerLogCertification log = FactoryEntitiy.createCustLogCertification();
        log.setDataExecucao(Calendar.getInstance().getTime());
        log.setInput(req);
        log.setOutput(ret);
        FactoryService.logCertification().salvaLog(log);
        
        return log;
    }
    
}
