package io.swagger.api.factories;

import io.swagger.api.CertificationApiService;
import io.swagger.api.impl.CertificationApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public class CertificationApiServiceFactory {

   private final static CertificationApiService service = new CertificationApiServiceImpl();

   public static CertificationApiService getCertificationApi()
   {
      return service;
   }
}
