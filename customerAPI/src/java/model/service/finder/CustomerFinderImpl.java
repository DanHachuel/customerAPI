/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.finder;

import dao.http.ContentType;
import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.enums.OrigemPlanta;
import dao.factory.FactoryDAO;
import dao.http.Urlss;
import io.swagger.model.GenericRequest;
import dao.request.RequestFactory;
import java.nio.charset.Charset;
import util.JacksonMapper;

public class CustomerFinderImpl implements CustomerFinder {

    @Override
    public EfikaCustomer getCustomer(GenericRequest req) throws Exception {
        JacksonMapper<EfikaCustomer> mapper = new JacksonMapper(EfikaCustomer.class);
        EfikaCustomer ret = mapper.deserialize(FactoryDAO.createHttpDAO().post(Urlss.CADASTRO_STEALER.getUrl(),
                RequestFactory.customerRequest(req),
                ContentType.JSON.getValor(), Charset.forName("UTF-8")));

        if (ret.getRede().getPlanta() == OrigemPlanta.VIVO1 || ret.getRede().getIpDslam() == null) {
            EfikaCustomer retNet = mapper.deserialize(FactoryDAO.createHttpDAO().get(Urlss.CADASTRO_NETWORK.getUrl() + ret.getInstancia(),
                    ContentType.JSON.getValor(), Charset.forName("UTF-8")));
            ret.setRede(retNet.getRede());
            ret.setRedeExterna(retNet.getRedeExterna());
            ret.setRadius(retNet.getRadius());
        }

        return ret;
    }

}
