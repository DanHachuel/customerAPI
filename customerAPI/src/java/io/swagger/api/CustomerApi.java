package io.swagger.api;

import br.net.gvt.efika.customer.EfikaCustomer;
import io.swagger.api.factories.CustomerApiServiceFactory;
import io.swagger.annotations.*;
import io.swagger.model.GenericRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;


@Path("/customer")

@io.swagger.annotations.Api(value = "the customer API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public class CustomerApi {

    private final CustomerApiService delegate = CustomerApiServiceFactory.getCustomerApi();

    @POST
    @Path("/findByParameter")

    @Produces({"application/json", "application/xml"})
    @ApiOperation(value = "Busca clientes através das chaves de negócio / atividade", notes = "", response = EfikaCustomer.class, tags = {"customer",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = EfikaCustomer.class)
        ,
        @ApiResponse(code = 400, message = "Invalid tag value", response = Void.class)})
    public Response findByParameter(@ApiParam(value = "", required = true) GenericRequest body, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.findByParameter(body, securityContext);
    }
}
