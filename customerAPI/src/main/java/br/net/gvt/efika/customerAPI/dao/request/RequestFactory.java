/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.request;

import br.net.gvt.efika.customerAPI.model.GenericRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G0041775
 */
public class RequestFactory {

    public static CustomerRequest customerRequest(GenericRequest gen) {
        return new CustomerRequest(gen);
    }
    

    public static QueueTaskRequest queueRequest() {
        QueueTaskRequest req = new QueueTaskRequest();
        req.setAmount(5);
        try {
            req.setConsumer("customerAPI: " + InetAddress.getLocalHost());
        } catch (UnknownHostException ex) {
            Logger.getLogger(RequestFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return req;
    }

}
