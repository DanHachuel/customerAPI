/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.configporta;

import br.net.gvt.efika.customerAPI.dao.factory.FactoryDAO;
import br.net.gvt.efika.customerAPI.dao.http.Urls;
import fulltest.FulltestRequest;
import fulltest.SetOntToOltRequest;
import fulltest.ValidacaoResult;
import java.util.List;
import telecom.properties.gpon.SerialOntGpon;

public class ConfigPortaDAOImpl implements ConfigPortaDAO {

    @Override
    public ValidacaoResult confiabilidadeRede(FulltestRequest request) throws Exception {
        return (ValidacaoResult) FactoryDAO.createHttpValidacaoResultDAO().post(Urls.CONF_REDE.getUrl(),
                request);
    }

    @Override
    public List<SerialOntGpon> ontsDisponiveis(FulltestRequest request) throws Exception {
        return (List<SerialOntGpon>) FactoryDAO.createHttpListDAO().post(Urls.ONTS_DISP.getUrl(),
                request);
    }

    @Override
    public ValidacaoResult setOntToOlt(SetOntToOltRequest request) throws Exception {
        return (ValidacaoResult) FactoryDAO.createHttpValidacaoResultDAO().post(Urls.SET_ONT.getUrl(),
                request);
    }

}
