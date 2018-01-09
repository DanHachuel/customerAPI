package io.swagger.api.impl;

import br.net.gvt.efika.customer.EfikaCustomer;
import io.swagger.api.*;
import io.swagger.model.CertificationResponse;
import io.swagger.model.GenericRequest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import model.service.CertificationService;
import model.service.CustomerFinder;
import model.service.FactoryService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public class CertificationApiServiceImpl extends CertificationApiService {

    private CustomerFinder finder = FactoryService.customerFinder();
    private CertificationService certificator = FactoryService.certSrvc();

    @Override
    public Response certification(GenericRequest body, SecurityContext securityContext)
            throws NotFoundException {
        try {
            return Response.ok().entity(certificator.fulltestByParam(body)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.ok().entity(e).build();
        }
    }

    @Override
    public Response findByCustomer(EfikaCustomer body, SecurityContext securityContext)
            throws NotFoundException {
        // do some magic!
        EfikaCustomer cst = new EfikaCustomer("designador");
        return Response.ok().entity(cst).build();
    }

    @Override
    public Response getCertificationById(Long id, SecurityContext securityContext)
            throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response updateCertification(CertificationResponse body, SecurityContext securityContext)
            throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
