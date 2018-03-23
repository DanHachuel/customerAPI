/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.customer;

import br.net.gvt.efika.customer.model.dto.GenericRequest;
import br.net.gvt.efika.efika_customer.model.customer.enums.TipoRede;
import br.net.gvt.efika.network_inventory.model.adapter.SigresAdapter;
import br.net.gvt.efika.network_inventory.model.service.FactoryOfflineNetworkInventoryService;

public class EfikaCustomerServiceV1Impl extends EfikaCustomerServiceGeneric {

    public EfikaCustomerServiceV1Impl() {
    }

    @Override
    protected void consultarInventarioRede() throws Exception {
        super.consultarInventarioRede();
        if (cust.getRede().getTipo() == TipoRede.GPON) {
            cust.setRede(SigresAdapter.adapt(FactoryOfflineNetworkInventoryService.newNetworkInventorySigresService().getOltDetail(new GenericRequest(cust.getRede().getIpDslam(), "customerAPI"))));
        } else {
            cust.setRede(SigresAdapter.adapt(FactoryOfflineNetworkInventoryService.newNetworkInventorySigresService().getDslamDetail(new GenericRequest(cust.getRede().getIpDslam(), "customerAPI"))));
        }
    }

}
