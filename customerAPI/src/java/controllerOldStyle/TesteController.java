/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerOldStyle;

/*
 *
 * @author G0041775
 */
import br.net.gvt.efika.customer.EfikaCustomer;
import io.swagger.api.NotFoundException;
import io.swagger.model.GenericRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import model.service.FactoryService;
import util.JacksonMapper;

@Path("/testeold")
public class TesteController {

    @POST
    @Path("/findByParameter")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByParameter(GenericRequest body) {

        try {
            // do some magic!
            EfikaCustomer e = FactoryService.customerFinder().getCustomer(body);
            System.out.println(new JacksonMapper(EfikaCustomer.class).serialize(e));
            return Response.ok().entity(e).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().entity(ex).build();
        }
    }
}
