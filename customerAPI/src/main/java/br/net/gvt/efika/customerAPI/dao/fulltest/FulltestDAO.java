/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.fulltest;

import br.net.gvt.efika.fulltest.FullTest;
import br.net.gvt.efika.fulltest.FulltestRequest;

/**
 *
 * @author G0042204
 */
public interface FulltestDAO {
    
    public FullTest fulltest(FulltestRequest request) throws Exception;
    
}
