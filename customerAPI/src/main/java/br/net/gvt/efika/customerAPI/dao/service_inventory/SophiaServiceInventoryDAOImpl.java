/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.service_inventory;

import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.dao.factory.FactoryDAO;
import br.net.gvt.efika.customerAPI.dao.http.Urls;
import br.net.gvt.efika.customerAPI.dao.request.RequestFactory;
import br.net.gvt.efika.customerAPI.model.GenericRequest;

public class SophiaServiceInventoryDAOImpl implements ServiceInventoryDAO {

    public SophiaServiceInventoryDAOImpl() {
    }

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
        return (EfikaCustomer) FactoryDAO.createHttpCustomerDAO().post(Urls.SERVICE_INVENTORY_SOPHIA.getUrl(),
                RequestFactory.customerRequest(new GenericRequest(instancia, "customerAPI")));
    }

}
