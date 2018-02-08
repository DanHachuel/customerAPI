package br.net.gvt.efika.customerAPI.rest.factories;

import br.net.gvt.efika.customerAPI.rest.CertificationApiService;
import br.net.gvt.efika.customerAPI.rest.impl.CertificationApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public class CertificationApiServiceFactory {

   private final static CertificationApiService service = new CertificationApiServiceImpl();

   public static CertificationApiService getCertificationApi()
   {
      return service;
   }
}
