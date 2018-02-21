/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.customer;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.dao.network_inventory.NetworkInventoryDAO;
import br.net.gvt.efika.customerAPI.dao.service_inventory.ServiceInventoryDAO;

public class EfikaCustomerServiceImpl implements EfikaCustomerService {

    private EfikaCustomer cust = new EfikaCustomer();

    private ServiceInventoryDAO servDAO;

    private NetworkInventoryDAO networkDAO;

    public EfikaCustomerServiceImpl(ServiceInventoryDAO servDAO, NetworkInventoryDAO networkDAO) {
        this.servDAO = servDAO;
        this.networkDAO = networkDAO;
    }

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
        cust = this.servDAO.consultar(instancia);
        cust.setRede(networkDAO.consultar(instancia));

        return this.cust;
    }

}
