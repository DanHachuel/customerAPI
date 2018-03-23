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

/**
 *
 * @author G0042204
 */
public class EfikaCustomerServiceGeneric implements EfikaCustomerService {

    protected EfikaCustomer cust;

    protected final void consultarInventarioServicos(String instancia) throws Exception {
        cust = FactoryServiceInventoryService.create().consultar(instancia);
    }

    protected void consultarInventarioRede() throws Exception {
        CustomerRequest req = new CustomerRequest();
        req.setCustomer(cust);
        EfikaCustomer c1 = FactoryNetworkInventoryService.newNetworkInventoryService().consultar(req);
        cust.setRede(c1.getRede());
        cust.setRadius(c1.getRadius());
    }

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
        this.consultarInventarioServicos(instancia);
        this.consultarInventarioRede();
        return this.cust;
    }

    protected final void asserts() {

    }

    public EfikaCustomer getCust() {
        return cust;
    }

    public void setCust(EfikaCustomer cust) {
        this.cust = cust;
    }

}
