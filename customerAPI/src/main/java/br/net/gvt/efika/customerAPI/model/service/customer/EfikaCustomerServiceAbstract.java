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
public abstract class EfikaCustomerServiceAbstract implements EfikaCustomerService {

    protected EfikaCustomer cust = new EfikaCustomer();

    protected final EfikaCustomer consultarInventarioServicos(String instancia) throws Exception {
        return FactoryServiceInventoryService.create().consultar(instancia);
    }

    protected EfikaCustomer consultarInventarioRede(EfikaCustomer cust) throws Exception {
        CustomerRequest req = new CustomerRequest();
        req.setCustomer(cust);
        return FactoryNetworkInventoryService.newNetworkInventoryService().consultar(req);
    }
    
    protected final void finalizar(){
    }

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
        cust = this.consultarInventarioServicos(instancia);
        return this.cust;
    }

    public EfikaCustomer getCust() {
        return cust;
    }

    public void setCust(EfikaCustomer cust) {
        this.cust = cust;
    }

}
