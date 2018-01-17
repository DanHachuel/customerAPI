/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.impl.cadastro;

import br.net.gvt.efika.customer.EfikaCustomer;
import model.entity.CertificationBlock;
import model.enums.CertificationBlockName;

public abstract class CadastroCertification extends CertificationBlock<EfikaCustomer> {

    public CadastroCertification() {
        super(CertificationBlockName.CADASTRO);
    }

}
