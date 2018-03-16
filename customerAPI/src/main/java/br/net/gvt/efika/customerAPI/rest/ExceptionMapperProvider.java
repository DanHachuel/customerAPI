/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.rest;

import br.net.gvt.efika.customerAPI.model.ModelApiResponse;
import javax.ejb.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author G0042204
 */
@Provider
@Singleton
public class ExceptionMapperProvider implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception exception) {
        return Response.status(400).entity(new ModelApiResponse(400, exception.getMessage())).type(MediaType.APPLICATION_JSON).build();
    }
}
