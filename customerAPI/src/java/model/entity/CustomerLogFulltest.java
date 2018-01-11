/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import fulltest.FullTest;
import org.mongodb.morphia.annotations.Embedded;

public class CustomerLogFulltest extends CustomerLog {

    @Embedded
    private FullTest output;

    public CustomerLogFulltest() {
    }

    public FullTest getOutput() {
        return output;
    }

    public void setOutput(FullTest output) {
        this.output = output;
    }

}
