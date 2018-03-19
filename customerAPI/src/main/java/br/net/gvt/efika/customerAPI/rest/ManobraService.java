/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.rest;

import br.net.gvt.efika.customer.model.manobra.dto.ManobraAnaliticoRequest;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.manobra.analitcs.FinalizacaoManobraAdapter;
import model.manobra.analitcs.MotivoManobraEnum;

import model.manobra.facade.AnalisadorManobraFacade;

/**
 *
 * @author G0042204
 */
@Path("/manobra")
public class ManobraService {

    @POST
    @Path("/analitico")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response analitico(ManobraAnaliticoRequest in) {
        try {
            return Response.ok(FinalizacaoManobraAdapter.adapter(new AnalisadorManobraFacade(in.getCustomer()).analisar())).build();
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }
    }

    @GET
    @Path("/motivos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarMotivos() {
        try {
            return Response.ok().entity(MotivoManobraEnum.values()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }
    }
    /**
     * Desativada
     */
//    @POST
//    @Path("/listarManobras")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response listarManobras(EfikaCustomer cust) {
//        Response r;
//        try {
//            r = ok(FactoryDAO.create().listarLogManobraPorCustomer(cust));
//        } catch (Exception e) {
//            r = serverError(e);
//        }
//        return r;
//    }

}
