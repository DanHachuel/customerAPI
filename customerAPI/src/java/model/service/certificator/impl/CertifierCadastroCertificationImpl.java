/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certificator.impl;

import br.net.gvt.efika.customer.EfikaCustomer;
import model.enums.CertificationAssertName;
import model.enums.CertificationResult;
import model.service.assertations.CustomerCertificationAsserter;
import model.service.certification.command.NonExceptionCommand;

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
    }

}
