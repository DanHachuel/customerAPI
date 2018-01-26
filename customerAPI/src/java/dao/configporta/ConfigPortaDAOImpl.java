/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.configporta;

import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.HttpDAO;
import dao.http.Urlss;
import fulltest.FullTest;
import fulltest.FulltestRequest;
import fulltest.ValidacaoResult;
import java.nio.charset.Charset;
import util.JacksonMapper;

public class ConfigPortaDAOImpl implements ConfigPortaDAO {

    private final HttpDAO dao = FactoryDAO.createHttpDAO();

    @Override
    public ValidacaoResult confiabilidadeRede(FulltestRequest request) throws Exception {
        JacksonMapper<ValidacaoResult> mapperFulltest = new JacksonMapper(ValidacaoResult.class);
        return mapperFulltest.deserialize(dao.post(Urlss.CONF_REDE.getUrl(),
                new FulltestRequest(request.getCust(), request.getExecutor()),
                ContentType.JSON.getCont(), Charset.forName("UTF-8")));
    }

}
