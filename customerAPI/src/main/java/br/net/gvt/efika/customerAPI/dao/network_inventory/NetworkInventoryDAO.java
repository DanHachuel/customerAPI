/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.network_inventory;

import br.net.gvt.efika.customer.model.customer.InventarioRede;

/**
 *
 * @author G0042204
 */
public interface NetworkInventoryDAO {

    public InventarioRede consultar(String instancia) throws Exception;

}
