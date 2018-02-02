package io.swagger.api;


import br.net.gvt.efika.customer.EfikaCustomer;
import io.swagger.model.CertificationResponse;
import io.swagger.model.GenericRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public abstract class CertificationApiService {
      public abstract Response certification(GenericRequest body,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response findByCustomer(EfikaCustomer body,SecurityContext securityContext)
      throws Exception;
      public abstract Response getCertificationById(Long id,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response updateCertification(CertificationResponse body,SecurityContext securityContext)
      throws NotFoundException;
}
