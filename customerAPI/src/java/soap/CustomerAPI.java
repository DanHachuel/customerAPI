/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap;

import br.net.gvt.efika.customer.EfikaCustomer;
import io.swagger.model.GenericRequest;
import javax.jws.WebMethod;
import javax.jws.WebService;
import model.entity.CustomerCertification;
import model.service.factory.FactoryService;

/**
 *
 * @author G0042204
 */
@WebService(serviceName = "customerService", portName = "8080")
public class CustomerAPI {

    @WebMethod(operationName = "certification")
    public CustomerCertification certification(GenericRequest body) throws Exception {
        try {
            return FactoryService.certSrvc().certificationByParam(body);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @WebMethod(operationName = "getCadastro")
    public EfikaCustomer getCadastro(GenericRequest body) throws Exception {
        try {
            return FactoryService.customerFinder().getCustomer(body);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
