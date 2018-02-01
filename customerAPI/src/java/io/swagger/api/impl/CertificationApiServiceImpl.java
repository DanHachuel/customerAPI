package io.swagger.api.impl;

import br.net.gvt.efika.customer.EfikaCustomer;
import io.swagger.api.*;
import io.swagger.model.CertificationResponse;
import io.swagger.model.GenericRequest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import model.service.factory.FactoryService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public class CertificationApiServiceImpl extends CertificationApiService {

    @Override
    public Response certification(GenericRequest body, SecurityContext securityContext)
            throws NotFoundException {
        try {
            return Response.ok().entity(FactoryService.certSrvc().certificationByParam(body)).build();
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

    @Override
    public Response confiabilidadeRede(GenericRequest body, SecurityContext securityContext) throws NotFoundException {
        try {
            return Response.ok().entity(FactoryService.certSrvc().certifyRede(body)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.ok().entity(e).build();
        }
    }

    @Override
    public Response ontsDisponiveis(GenericRequest body, SecurityContext securityContext) throws NotFoundException {
        try {
            return Response.ok().entity(FactoryService.certSrvc().ontsDisp(body)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.ok().entity(e).build();
        }
    }

    @Override
    public Response setOntToOlt(GenericRequest body, SecurityContext securityContext) throws NotFoundException {
        try {
            return Response.ok().entity(FactoryService.certSrvc().setOntToOlt(body)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.ok().entity(e).build();
        }
    }
}
