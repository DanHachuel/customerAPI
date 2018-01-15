/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.fulltest;

import fulltest.FullTest;
import fulltest.FulltestRequest;

/**
 *
 * @author G0042204
 */
public interface FulltestDAO {
    
    public FullTest fulltest(FulltestRequest request) throws Exception;
    
}
