package br.net.gvt.efika.customerAPI.rest;


import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.model.CertificationResponse;
import br.net.gvt.efika.customerAPI.model.GenericRequest;
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
      public abstract Response confiabilidadeRede(GenericRequest body,SecurityContext securityContext)
      throws NotFoundException;      
      public abstract Response ontsDisponiveis(GenericRequest body,SecurityContext securityContext)
      throws NotFoundException;      
      public abstract Response setOntToOlt(GenericRequest body,SecurityContext securityContext)
      throws NotFoundException;
}
