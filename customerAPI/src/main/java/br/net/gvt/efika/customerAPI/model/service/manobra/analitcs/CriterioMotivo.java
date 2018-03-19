/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.manobra.analitcs;

import br.net.gvt.efika.customer.model.manobra.enums.ConclusaoManobraEnum;
import br.net.gvt.efika.efika_customer.model.customer.CustomerAssert;
import java.util.ArrayList;
import java.util.List;
import model.manobra.analitcs.Checker;

/**
 *
 * @author G0042204
 */
public class CriterioMotivo implements Checker {

    private List<CustomerAssert> criterios;

    private ConclusaoManobraEnum conclusao;

    public CriterioMotivo() {
    }

    public void adicionarCriterio(CustomerAssert c) {
        getCriterios().add(c);
    }

    /**
     *
     * @param lst asserts do customer
     * @return
     */
    @Override
    public Boolean check(List<CustomerAssert> lst) {
        return lst.containsAll(criterios);
    }

    public List<CustomerAssert> getCriterios() {
        if (criterios == null) {
            criterios = new ArrayList<>();
        }
        return criterios;
    }

    public ConclusaoManobraEnum getConclusao() {
        return conclusao;
    }

    public void setConclusao(ConclusaoManobraEnum conclusao) {
        this.conclusao = conclusao;
    }

}
