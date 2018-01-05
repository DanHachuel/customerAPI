/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import dao.http.Urls;
import dao.http.ContentType;
import br.net.gvt.efika.customer.EfikaCustomer;
import dao.factory.FactoryDAO;
import dao.http.HttpDAO;
import io.swagger.model.GenericRequest;
import dao.request.RequestFactory;
import util.JacksonMapper;

public class CustomerFinderImpl implements CustomerFinder {

    private static final HttpDAO HTTP_DAO = FactoryDAO.createHttpDAO();

    @Override
    public EfikaCustomer getCustomer(GenericRequest req) throws Exception {
        JacksonMapper<EfikaCustomer> mapper = new JacksonMapper(EfikaCustomer.class);
        return mapper.deserialize(HTTP_DAO.post(
                Urls.CADASTRO_STEALER.getValor(),
                RequestFactory.customerRequest(req),
                ContentType.JSON.getValor()));
    }

}
