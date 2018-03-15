package br.net.gvt.efika.customerAPI.rest;

import br.net.gvt.efika.customer.model.dto.GenericRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public abstract class CustomerApiService {
      public abstract Response findByParameter(GenericRequest body,SecurityContext securityContext)
      throws NotFoundException;
}
