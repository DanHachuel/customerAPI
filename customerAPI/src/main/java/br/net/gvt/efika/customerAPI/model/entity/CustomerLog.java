/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import br.net.gvt.efika.customerAPI.model.GenericRequest;
import java.util.Calendar;
import java.util.Date;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author G0041775
 */
@Entity(value = "log", noClassnameStored = false)
public abstract class CustomerLog {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private Date dataInicio;

    private Date dataFim;

    private GenericRequest input;

    public CustomerLog() {
        this.dataInicio = Calendar.getInstance().getTime();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public GenericRequest getInput() {
        return input;
    }

    public void setInput(GenericRequest input) {
        this.input = input;
    }

}
