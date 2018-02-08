package br.net.gvt.efika.customerAPI.rest.factories;

import br.net.gvt.efika.customerAPI.rest.CustomerApiService;
import br.net.gvt.efika.customerAPI.rest.impl.CustomerApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-01-04T13:39:04.668Z")
public class CustomerApiServiceFactory {

   private final static CustomerApiService service = new CustomerApiServiceImpl();

   public static CustomerApiService getCustomerApi()
   {
      return service;
   }
}
