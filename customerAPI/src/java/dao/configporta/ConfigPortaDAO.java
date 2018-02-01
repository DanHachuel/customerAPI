/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.configporta;

import fulltest.FulltestRequest;
import fulltest.ValidacaoResult;
import java.util.List;
import telecom.properties.gpon.SerialOntGpon;

/**
 *
 * @author G0041775
 */
public interface ConfigPortaDAO {

    public ValidacaoResult confiabilidadeRede(FulltestRequest request) throws Exception;

    public List<SerialOntGpon> ontsDisponiveis(FulltestRequest request) throws Exception;

}
