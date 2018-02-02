/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.configporta;

import dao.factory.FactoryDAO;
import dao.http.Urlss;
import fulltest.FulltestRequest;
import fulltest.SetOntToOltRequest;
import fulltest.ValidacaoResult;
import java.util.List;
import telecom.properties.gpon.SerialOntGpon;

public class ConfigPortaDAOImpl implements ConfigPortaDAO {

    @Override
    public ValidacaoResult confiabilidadeRede(FulltestRequest request) throws Exception {
        return (ValidacaoResult) FactoryDAO.createHttpValidacaoResultDAO().post(
                Urlss.CONF_REDE.getUrl(),
                request);
    }

    @Override
    public List<SerialOntGpon> ontsDisponiveis(FulltestRequest request) throws Exception {
        return (List<SerialOntGpon>) FactoryDAO.createHttpListDAO().post(
                Urlss.ONTS_DISP.getUrl(),
                request);
    }

    @Override
    public ValidacaoResult setOntToOlt(SetOntToOltRequest request) throws Exception {
        return (ValidacaoResult) FactoryDAO.createHttpValidacaoResultDAO().post(
                Urlss.SET_ONT.getUrl(),
                request);
    }

}
