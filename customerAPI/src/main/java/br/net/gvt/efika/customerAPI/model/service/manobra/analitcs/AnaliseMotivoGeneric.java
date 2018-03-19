/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.manobra.analitcs;

import br.net.gvt.efika.customer.model.manobra.enums.MotivoManobraEnum;
import br.net.gvt.efika.efika_customer.model.customer.CustomerAssert;
import java.util.List;

/**
 *
 * @author G0042204
 */
public class AnaliseMotivoGeneric extends AnaliseMotivoAbstract {

    public AnaliseMotivoGeneric(List<CustomerAssert> asserts, MotivoManobraEnum motivo) {
        super(asserts, motivo, FactoryCriterio.obter(motivo));
    }

}
