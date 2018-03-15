package br.net.gvt.efika.customerAPI.rest.impl;

import br.net.gvt.efika.customer.model.dto.GenericRequest;
import br.net.gvt.efika.customerAPI.rest.CustomerApiService;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import br.net.gvt.efika.customerAPI.model.service.factory.FactoryService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public class CustomerApiServiceImpl extends CustomerApiService {

    @Override
    public Response findByParameter(GenericRequest body, SecurityContext securityContext)
            throws NotFoundException {
        try {
            // do some magic!
            // return Response.ok().entity(FactoryService.createEfikaCustomerService().consultar(body.getParameter())).build();
            return Response.ok().entity(FactoryService.customerFinder().getCustomer(body)).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().entity(ex).build();
        }
    }
}
