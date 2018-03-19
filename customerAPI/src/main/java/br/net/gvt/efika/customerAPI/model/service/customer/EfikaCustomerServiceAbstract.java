/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.customer;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRadius;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.util.thread.EfikaAbstractRunnable;

/**
 *
 * @author G0042204
 */
public abstract class EfikaCustomerServiceAbstract implements EfikaCustomerService {

    protected EfikaCustomer cust = new EfikaCustomer();

    protected abstract EfikaCustomer consultarInventarioServicos(String instancia) throws Exception;

    protected abstract InventarioRede consultarInventarioRede(EfikaCustomer cust) throws Exception;

    protected abstract InventarioRadius consultarInventarioRadius(EfikaCustomer cust) throws Exception;

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
//        try {
        cust = this.consultarInventarioServicos(instancia);

        EfikaAbstractRunnable run = new EfikaAbstractRunnable() {
            @Override
            public void processar() throws Exception {
                EfikaCustomerServiceAbstract scope = EfikaCustomerServiceAbstract.this;
                scope.cust.setRede(scope.consultarInventarioRede(scope.cust));
            }
        };
        run.start();

        
        
        run.join();
        return this.cust;
    }

    public EfikaCustomer getCust() {
        return cust;
    }

    public void setCust(EfikaCustomer cust) {
        this.cust = cust;
    }

}
