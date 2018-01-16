/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.exception;

import dao.AbstractMongoDAO;
import model.entity.ExceptionLog;

public class ExceptionLogDAOImpl extends AbstractMongoDAO<ExceptionLog> {

    public ExceptionLogDAOImpl() {
        super("10.40.197.137", "customerAPI", ExceptionLog.class);
    }

}
