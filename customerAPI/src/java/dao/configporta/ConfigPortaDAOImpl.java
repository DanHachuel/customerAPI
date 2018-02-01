/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.configporta;

import dao.factory.FactoryDAO;
import dao.http.Urlss;
import fulltest.FulltestRequest;
import fulltest.ValidacaoResult;

public class ConfigPortaDAOImpl implements ConfigPortaDAO {

    @Override
    public ValidacaoResult confiabilidadeRede(FulltestRequest request) throws Exception {
        return (ValidacaoResult) FactoryDAO.createHttpValidacaoResultDAO().post(
                Urlss.CONF_REDE.getUrl(),
                new FulltestRequest(request.getCust(), request.getExecutor()));
    }

}
