/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.finder;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.model.GenericRequest;
import br.net.gvt.efika.customerAPI.dao.request.RequestFactory;
import br.net.gvt.efika.util.dao.http.factory.FactoryHttpDAOAbstract;

public class CustomerFinderImpl implements CustomerFinder {

    @Override
    public EfikaCustomer getCustomer(GenericRequest req) throws Exception {
        FactoryHttpDAOAbstract<EfikaCustomer> fac = new FactoryHttpDAOAbstract<>(EfikaCustomer.class);
        return (EfikaCustomer) fac.createWithoutProxy().post(br.net.gvt.efika.util.dao.http.Urls.CADASTRO_STEALER.getUrl(),
                RequestFactory.customerRequest(req));
    }

}
