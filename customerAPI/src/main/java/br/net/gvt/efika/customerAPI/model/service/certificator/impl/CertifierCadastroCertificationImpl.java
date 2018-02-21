/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certificator.impl;

import br.net.gvt.efika.customer.model.certification.enums.CertificationAssertName;
import br.net.gvt.efika.customer.model.certification.enums.CertificationResult;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customerAPI.model.service.assertations.CustomerCertificationAsserter;
import br.net.gvt.efika.customerAPI.model.service.certification.command.NonExceptionCommand;

public class CertifierCadastroCertificationImpl extends CertifierCertificationBlockGeneric {

    private EfikaCustomer customer;

    public CertifierCadastroCertificationImpl(EfikaCustomer customer) {
        this.customer = customer;
    }

    public CertifierCadastroCertificationImpl() {
    }

    @Override
    protected void process() {
        if (customer != null) {
            for (CertificationAssertName value : getAsserts()) {
                new NonExceptionCommand() {
                    @Override
                    public void run() throws Exception {
                        CertifierCadastroCertificationImpl.this.getBlock().getAsserts().add(new CustomerCertificationAsserter().assertCertification(value, CertifierCadastroCertificationImpl.this.customer));
                    }
                };
            }
            this.check();
        } else {
            getBlock().concluir(CertificationResult.FORWARDED_CO, "Cadastro NOK.");
        }
    }

    @Override
    public void definirAsserts() {
        this.asserts.add(CertificationAssertName.HAS_BLOQ_RADIUS);
        this.asserts.add(CertificationAssertName.IS_INV_REDE_EQUALS_RADIUS);
        this.asserts.add(CertificationAssertName.HAS_INV_REDE);
        this.asserts.add(CertificationAssertName.HAS_INV_SERV);
    }

}
