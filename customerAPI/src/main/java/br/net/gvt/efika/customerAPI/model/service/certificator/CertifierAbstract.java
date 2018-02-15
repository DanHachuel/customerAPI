/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certificator;

/**
 *
 * @author G0042204
 * @param <T>
 */
public abstract class CertifierAbstract<T> implements Certifier<T> {

    protected abstract void check();
    
    protected abstract void process();
        
}
