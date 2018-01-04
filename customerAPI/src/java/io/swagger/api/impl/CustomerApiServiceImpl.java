package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.GenericRequest;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public class CustomerApiServiceImpl extends CustomerApiService {
      @Override
      public Response findByParameter(GenericRequest body,SecurityContext securityContext)
      throws NotFoundException {
          

          // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
}
