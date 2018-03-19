/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.customer;

import br.net.gvt.efika.customer.model.dto.GenericRequest;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.enums.TipoRede;
import br.net.gvt.efika.network_inventory.model.adapter.SigresAdapter;
import br.net.gvt.efika.network_inventory.model.dto.OltDetailSigresFibraDTO;
import br.net.gvt.efika.network_inventory.model.service.FactoryOfflineNetworkInventoryService;
import br.net.gvt.efika.util.thread.EfikaAbstractRunnable;

public class EfikaCustomerServiceV1Impl extends EfikaCustomerServiceAbstract {

    public EfikaCustomerServiceV1Impl() {
    }

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
        super.consultar(instancia);
        this.consultarInventarioRede(this.cust);

        return this.cust;
    }

    @Override
    protected EfikaCustomer consultarInventarioRede(EfikaCustomer cust) throws Exception {
        EfikaCustomer ec2 = super.consultarInventarioRede(cust);
        cust.setRede(ec2.getRede());
        cust.setRadius(ec2.getRadius());

        if (cust.getRede().getTipo() == TipoRede.GPON) {
            cust.setRede(SigresAdapter.adapt(FactoryOfflineNetworkInventoryService.newNetworkInventorySigresService().getOltDetail(new GenericRequest(cust.getRede().getIpDslam(), "customerAPI"))));
        } else {
            cust.setRede(SigresAdapter.adapt(FactoryOfflineNetworkInventoryService.newNetworkInventorySigresService().getDslamDetail(new GenericRequest(cust.getRede().getIpDslam(), "customerAPI"))));
        }
        return cust;
    }

}
