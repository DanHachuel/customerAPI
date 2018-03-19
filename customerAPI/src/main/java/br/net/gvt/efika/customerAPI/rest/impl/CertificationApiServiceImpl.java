package br.net.gvt.efika.customerAPI.rest.impl;

import br.net.gvt.efika.customer.model.dto.CustomerRequest;
import br.net.gvt.efika.customer.model.dto.GenericRequest;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.dao.mongo.FactoryDAO;
import br.net.gvt.efika.customerAPI.rest.ApiResponseMessage;
import br.net.gvt.efika.customerAPI.rest.CertificationApiService;
import br.net.gvt.efika.customerAPI.model.CertificationResponse;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import br.net.gvt.efika.customerAPI.model.service.factory.FactoryService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public class CertificationApiServiceImpl extends CertificationApiService {

    @Override
    public Response certification(CustomerRequest body, SecurityContext securityContext)
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
            throws Exception {
        CustomerRequest req = new CustomerRequest();
        req.setCustomer(body);
        return Response.ok().entity(FactoryService.certSrvc().findByCustomer(req)).build();
    }

    @Override
    public Response getCertificationById(String id, SecurityContext securityContext)
            throws NotFoundException {
        try {
            return Response.ok().entity(FactoryDAO.newCertificationDAO().read(id)).build();
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }
    }

    @Override
    public Response updateCertification(CertificationResponse body, SecurityContext securityContext)
            throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response confiabilidadeRede(CustomerRequest body, SecurityContext securityContext) throws NotFoundException {
        try {
            return Response.ok().entity(FactoryService.certSrvc().certifyRede(body)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.ok().entity(e).build();
        }
    }

    @Override
    public Response ontsDisponiveis(CustomerRequest body, SecurityContext securityContext) throws NotFoundException {
        try {
            return Response.ok().entity(FactoryService.certSrvc().ontsDisp(body)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.ok().entity(e).build();
        }
    }

    @Override
    public Response setOntToOlt(CustomerRequest body, SecurityContext securityContext) throws NotFoundException {
        try {
            return Response.ok().entity(FactoryService.certSrvc().setOntToOlt(body)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.ok().entity(e).build();
        }
    }
}
