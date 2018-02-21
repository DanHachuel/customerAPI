/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.service_inventory;

import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemInventarioServico;

/**
 *
 * @author G0042204
 */
public class FactoryServiceInventoryDAO {

    public static ServiceInventoryDAO create(OrigemInventarioServico origem) throws Exception {
        if (origem == OrigemInventarioServico.SOPHIA) {
            return new SophiaServiceInventoryDAOImpl();
        } else if (origem == OrigemInventarioServico.LEGADO_VIVO1) {
            return new LegadoServiceInventoryDAOImpl();
        }

        throw new Exception("Provedor de Iventário de Serviços indisponível para: " + origem.name());

    }

}
