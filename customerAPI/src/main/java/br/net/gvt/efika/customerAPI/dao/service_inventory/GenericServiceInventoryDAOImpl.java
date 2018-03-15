/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.service_inventory;

import br.net.gvt.efika.customer.model.dto.GenericRequest;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.dao.request.RequestFactory;
import br.net.gvt.efika.util.dao.http.Urls;
import br.net.gvt.efika.util.dao.http.factory.FactoryHttpDAOAbstract;

public class GenericServiceInventoryDAOImpl implements ServiceInventoryDAO {

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
        FactoryHttpDAOAbstract<EfikaCustomer> fac = new FactoryHttpDAOAbstract<>(EfikaCustomer.class);
        return (EfikaCustomer) fac.createWithoutProxy().post(Urls.SERVICE_INVENTORY.getUrl(),
                RequestFactory.customerRequest(new GenericRequest(instancia, "customerAPI")));

    }

}
