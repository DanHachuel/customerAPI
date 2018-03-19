/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.customer;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.util.thread.EfikaAbstractRunnable;

public class EfikaCustomerServiceV2Impl extends EfikaCustomerServiceAbstract {

    public EfikaCustomerServiceV2Impl() {

    }



    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
        super.consultar(instancia); //To change body of generated methods, choose Tools | Templates.
        EfikaAbstractRunnable run = new EfikaAbstractRunnable() {
            @Override
            public void processar() throws Exception {
                EfikaCustomerServiceV2Impl scope = EfikaCustomerServiceV2Impl.this;
                EfikaCustomer ec2 = scope.consultarInventarioRede(scope.cust);
                scope.cust.setRede(ec2.getRede());
                scope.cust.setRadius(ec2.getRadius());
            }
        };

        run.start();
        run.join();

        return this.cust;
    }

}
