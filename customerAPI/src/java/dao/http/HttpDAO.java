/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.http;

import java.nio.charset.Charset;

/**
 *
 * @author G0041775
 */
public interface HttpDAO {

    public String get(String url, String contentType, Charset responseCharset) throws Exception;
    
    public String post(String url, Object obj, String contentType, Charset responseCharset) throws Exception;
    
}
