/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerOldStyle;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author G0041775
 */
public class TesteApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    private Set<Class<?>> empty = new HashSet<Class<?>>();

    public TesteApplication() {
        singletons.add(new TesteController());
    }

    public Set<Object> getSingletons() {

        return singletons;

    }

    public Set<Class<?>> getEmpty() {

        return empty;

    }
}
