/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.customer;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.util.thread.EfikaAbstractRunnable;

/**
 *
 * @author G0042204
 */
public abstract class EfikaCustomerServiceAbstract implements EfikaCustomerService {

    protected EfikaCustomer cust = new EfikaCustomer();

    protected abstract EfikaCustomer consultarInventarioServicos(String instancia) throws Exception;

    protected abstract EfikaCustomer consultarInventarioRede(EfikaCustomer cust) throws Exception;

    protected abstract EfikaCustomer consultarInventarioRadius(EfikaCustomer cust) throws Exception;

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
//        try {
        cust = this.consultarInventarioServicos(instancia);

        EfikaAbstractRunnable run = new EfikaAbstractRunnable() {
            @Override
            public void processar() throws Exception {
                EfikaCustomerServiceAbstract scope = EfikaCustomerServiceAbstract.this;
                EfikaCustomer ec2 = scope.consultarInventarioRede(scope.cust);
                scope.cust.setRede(ec2.getRede());
                scope.cust.setRadius(ec2.getRadius());
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
