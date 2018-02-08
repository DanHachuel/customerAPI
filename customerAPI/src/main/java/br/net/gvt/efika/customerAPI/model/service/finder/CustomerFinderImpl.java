/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.finder;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.dao.factory.FactoryDAO;
import br.net.gvt.efika.customerAPI.dao.http.Urlss;
import br.net.gvt.efika.customerAPI.model.GenericRequest;
import br.net.gvt.efika.customerAPI.dao.request.RequestFactory;

public class CustomerFinderImpl implements CustomerFinder {

    @Override
    public EfikaCustomer getCustomer(GenericRequest req) throws Exception {
        EfikaCustomer ret = (EfikaCustomer) FactoryDAO.createHttpCustomerDAO().post(Urlss.CADASTRO_STEALER.getUrl(),
                RequestFactory.customerRequest(req));

        if (ret.getRede().getIpDslam() == null) {
            EfikaCustomer retNet = (EfikaCustomer) FactoryDAO.createHttpCustomerDAO().get(
                    Urlss.CADASTRO_NETWORK.getUrl() + ret.getInstancia());
            ret.setRede(retNet.getRede());
            ret.setRedeExterna(retNet.getRedeExterna());
            ret.setRadius(retNet.getRadius());
        }

        return ret;
    }

}
