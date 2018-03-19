/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.customer;

import br.net.gvt.efika.customer.model.dto.CustomerRequest;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealer.model.service.network_inventory.FactoryNetworkInventoryService;
import br.net.gvt.efika.stealer.model.service.service_inventory.FactoryServiceInventoryService;

public class EfikaCustomerServiceV2Impl extends EfikaCustomerServiceAbstract {

    public EfikaCustomerServiceV2Impl() {

    }

    @Override
    protected EfikaCustomer consultarInventarioServicos(String instancia) throws Exception {
        return FactoryServiceInventoryService.create().consultar(instancia);
    }

    @Override
    protected EfikaCustomer consultarInventarioRede(EfikaCustomer cust) throws Exception {
        CustomerRequest req = new CustomerRequest();
        req.setCustomer(cust);
        return FactoryNetworkInventoryService.newNetworkInventoryService().consultar(req);
    }

    @Override
    protected EfikaCustomer consultarInventarioRadius(EfikaCustomer cust) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
