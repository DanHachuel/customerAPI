/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.customer;

import br.net.gvt.efika.customerAPI.dao.network_inventory.FactoryNetworkInventoryDAO;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.dao.service_inventory.FactoryServiceInventoryDAO;
import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemInventarioServico;

public class EfikaCustomerServiceImpl implements EfikaCustomerService {

    private EfikaCustomer cust = new EfikaCustomer();

    public EfikaCustomerServiceImpl() {

    }

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
        try {
            cust = FactoryServiceInventoryDAO.create(OrigemInventarioServico.SOPHIA).consultar(instancia);
            cust.setRede(FactoryNetworkInventoryDAO.create().consultar(cust));
            cust.getServicos().setOrigem(OrigemInventarioServico.SOPHIA);
            return this.cust;
        } catch (Exception e) {
            EfikaCustomer legado = FactoryServiceInventoryDAO.create(OrigemInventarioServico.LEGADO_VIVO1).consultar(instancia);
            legado.getServicos().setOrigem(OrigemInventarioServico.LEGADO_VIVO1);
            
            
            
            return legado;
        }

    }

}
