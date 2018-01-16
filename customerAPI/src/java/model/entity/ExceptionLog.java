/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author G0042204
 */
@Entity("exception_customerAPI")
public class ExceptionLog {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private List<Object> bundle;

    public ExceptionLog() {
    }

    public ExceptionLog(Object e) {
        getBundle().add(e);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Object> getBundle() {
        if (bundle == null) {
            bundle = new ArrayList<>();
        }
        return bundle;
    }

    public void setBundle(List<Object> bundle) {
        this.bundle = bundle;
    }

}
