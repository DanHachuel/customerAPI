/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.network_inventory;

import br.net.gvt.efika.customer.model.dto.CustomerRequest;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.util.dao.http.Urls;
import br.net.gvt.efika.util.dao.http.factory.FactoryHttpDAOAbstract;

public class GenericNetworkInventoryDAOImpl implements NetworkInventoryDAO {

    @Override
    public InventarioRede consultar(EfikaCustomer cust) throws Exception {

        CustomerRequest req = new CustomerRequest();
        req.setCust(cust);
        req.setExecutor("customerAPI");
        FactoryHttpDAOAbstract<InventarioRede> fac = new FactoryHttpDAOAbstract<>(InventarioRede.class);
        return (InventarioRede) fac.createWithoutProxy().post(Urls.NETWORK_INVENTORY.getUrl(), req);
    }

}
