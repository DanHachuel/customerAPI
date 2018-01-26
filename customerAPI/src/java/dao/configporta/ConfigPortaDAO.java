/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.configporta;

import fulltest.FulltestRequest;
import fulltest.ValidacaoResult;

/**
 *
 * @author G0041775
 */
public interface ConfigPortaDAO {

    public ValidacaoResult confiabilidadeRede(FulltestRequest request) throws Exception;

}
