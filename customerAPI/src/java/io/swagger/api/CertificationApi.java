package io.swagger.api;

import br.net.gvt.efika.customer.EfikaCustomer;
import io.swagger.api.factories.CertificationApiServiceFactory;

import io.swagger.annotations.ApiParam;

import io.swagger.model.CertificationResponse;
import io.swagger.model.GenericRequest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/certification")

@io.swagger.annotations.Api(description = "the certification API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public class CertificationApi {

    private final CertificationApiService delegate = CertificationApiServiceFactory.getCertificationApi();

    @POST
    @Path("/execByParam")
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    @io.swagger.annotations.ApiOperation(value = "Certificação dos produtos contratados", notes = "", response = CertificationResponse.class, tags = {"certification",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = CertificationResponse.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class)})
    public Response certification(@ApiParam(value = "Pet object that needs to be added to the store", required = true) GenericRequest body, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.certification(body, securityContext);
    }

    @POST
    @Path("/confRede")
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    @io.swagger.annotations.ApiOperation(value = "Certificação dos produtos contratados", notes = "", response = CertificationResponse.class, tags = {"certification",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = CertificationResponse.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class)})
    public Response confiabilidadeRede(@ApiParam(value = "Pet object that needs to be added to the store", required = true) GenericRequest body, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.confiabilidadeRede(body, securityContext);
    }

    @POST
    @Path("/ontsDisp")
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    @io.swagger.annotations.ApiOperation(value = "Certificação dos produtos contratados", notes = "", response = CertificationResponse.class, tags = {"certification",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = CertificationResponse.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class)})
    public Response ontsDisponiveis(@ApiParam(value = "Pet object that needs to be added to the store", required = true) GenericRequest body, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.ontsDisponiveis(body, securityContext);
    }

    @POST
    @Path("/setOntToOlt")
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    @io.swagger.annotations.ApiOperation(value = "Certificação dos produtos contratados", notes = "", response = CertificationResponse.class, tags = {"certification",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = CertificationResponse.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class)})
    public Response setOntToOlt(@ApiParam(value = "Pet object that needs to be added to the store", required = true) GenericRequest body, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.setOntToOlt(body, securityContext);
    }

    @POST
    @Path("/findByCustomer")

    @Produces({"application/json", "application/xml"})
    @io.swagger.annotations.ApiOperation(value = "Busca Certificações por Cliente", notes = "desc", response = CertificationResponse.class, responseContainer = "List", tags = {"certification",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = CertificationResponse.class, responseContainer = "List")
        ,
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid status value", response = Void.class) })
    public Response findByCustomer(@ApiParam(value = "EfikaCustomer Object" ,required=true) EfikaCustomer body,@Context SecurityContext securityContext)
    throws Exception {
        return delegate.findByCustomer(body,securityContext);
    }

    @GET
    @Path("/{id}")

    @Produces({"application/json", "application/xml"})
    @io.swagger.annotations.ApiOperation(value = "Obtem Certificação pelo Id", notes = "Retorna detalhe de uma Certificação", response = CertificationResponse.class, tags = {"certification",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = CertificationResponse.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Certificação não encontrada!", response = Void.class)})
    public Response getCertificationById(@PathParam("id") Long id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getCertificationById(id, securityContext);
    }

    @PUT

    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    @io.swagger.annotations.ApiOperation(value = "Atualiza Certificação", notes = "", response = Void.class, tags = {"certification",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Pet not found", response = Void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Validation exception", response = Void.class)})
    public Response updateCertification(@ApiParam(value = "Pet object that needs to be added to the store", required = true) CertificationResponse body, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateCertification(body, securityContext);
    }
}
