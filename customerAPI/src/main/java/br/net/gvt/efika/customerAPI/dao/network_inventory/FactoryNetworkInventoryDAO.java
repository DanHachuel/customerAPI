/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.network_inventory;

/**
 *
 * @author G0042204
 */
public class FactoryNetworkInventoryDAO {

    public static NetworkInventoryDAO create() {
        return new GenericNetworkInventoryDAOImpl();
    }

}
