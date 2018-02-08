package br.net.gvt.efika.customerAPI.rest;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.rest.factories.CertificationApiServiceFactory;
import br.net.gvt.efika.customerAPI.model.CertificationResponse;
import br.net.gvt.efika.customerAPI.model.GenericRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/certification")
public class CertificationApi {

    private final CertificationApiService delegate = CertificationApiServiceFactory.getCertificationApi();

    @POST
    @Path("/execByParam")
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    public Response certification(GenericRequest body, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.certification(body, securityContext);
    }

    @POST
    @Path("/findByCustomer")
    @Produces({"application/json", "application/xml"})
    public Response findByCustomer(EfikaCustomer body, @Context SecurityContext securityContext)
            throws Exception {
        return delegate.findByCustomer(body, securityContext);
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json", "application/xml"})
    public Response getCertificationById(@PathParam("id") Long id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getCertificationById(id, securityContext);
    }

    @PUT
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    public Response updateCertification(CertificationResponse body, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateCertification(body, securityContext);
    }
}
