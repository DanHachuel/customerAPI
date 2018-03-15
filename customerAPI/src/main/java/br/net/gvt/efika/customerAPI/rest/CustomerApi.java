package br.net.gvt.efika.customerAPI.rest;

import br.net.gvt.efika.customer.model.dto.GenericRequest;
import br.net.gvt.efika.customerAPI.rest.factories.CustomerApiServiceFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/customer")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public class CustomerApi {

    private final CustomerApiService delegate = CustomerApiServiceFactory.getCustomerApi();

    @POST
    @Path("/findByParameter")
    @Produces({"application/json", "application/xml"})
    public Response findByParameter(GenericRequest body, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.findByParameter(body, securityContext);
    }
}
