/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.network_inventory;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.customerAPI.dao.request.RequestFactory;
import br.net.gvt.efika.customerAPI.model.GenericRequest;
import br.net.gvt.efika.util.dao.http.Urls;
import br.net.gvt.efika.util.dao.http.factory.FactoryHttpDAOAbstract;

public class SigresNetworkInventoryDAOImpl implements NetworkInventoryDAO {

    @Override
    public InventarioRede consultar(String instancia) throws Exception {
        FactoryHttpDAOAbstract<EfikaCustomer> fac = new FactoryHttpDAOAbstract<>(EfikaCustomer.class);
        EfikaCustomer ec = (EfikaCustomer) fac.createWithoutProxy().post(Urls.SERVICE_INVENTORY_LEGADO_V1.getUrl(),
                RequestFactory.customerRequest(new GenericRequest(instancia, "customerAPI")));
        return ec.getRede();
    }

}
