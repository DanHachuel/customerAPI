/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.exception;

import br.net.gvt.efika.customerAPI.model.entity.ExceptionLog;
import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;

public class ExceptionLogDAOImpl extends AbstractMongoDAO<ExceptionLog> {

    public ExceptionLogDAOImpl() {
        super("10.40.197.137", "customerAPI", ExceptionLog.class);
    }

}
