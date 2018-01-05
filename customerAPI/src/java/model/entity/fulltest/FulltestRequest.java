package model.entity.fulltest;

import br.net.gvt.efika.customer.EfikaCustomer;

public class FulltestRequest {

    private EfikaCustomer cust;
    private String executor;

    public FulltestRequest() {
    }

    public FulltestRequest(EfikaCustomer cust, String executor) {
        this.cust = cust;
        this.executor = executor;
    }

    public EfikaCustomer getCust() {
        return cust;
    }

    public void setCust(EfikaCustomer cust) {
        this.cust = cust;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

}
