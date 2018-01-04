/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.queue.enuns;

/**
 *
 * @author G0042204
 */
public enum TasksEnum {

    FULLTEST("Fulltest");

    private final String desc;

    private TasksEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
