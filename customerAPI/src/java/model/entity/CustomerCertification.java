package model.entity;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import fulltest.FullTest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.enums.CertificationResult;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author G0042204
 */
@Entity("certification")
public class CustomerCertification extends Certificational {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private List<CertificationBlock> blocks;

    private Date dataInicio;

    private Date dataFim;

    private EfikaCustomer customer;

    private String executor;

    private FullTest fulltest;

    public CustomerCertification() {
        dataInicio = Calendar.getInstance().getTime();
    }

    @Override
    public void check() {
        for (CertificationBlock block : blocks) {

            if (block.getResultado() == CertificationResult.FORWARDED_CO) {
                this.concluir(block.getResultado(), block.getOrientacao());
                break;
            }

            if (block.getResultado() == CertificationResult.TO_FIX) {
                this.concluir(block.getResultado(), block.getOrientacao());
                break;
            }
        }

        if (this.getOrientacao() == null) {
            this.concluir(CertificationResult.OK, "OK");
        }
    }

    public List<CertificationBlock> getBlocks() {
        if (blocks == null) {
            blocks = new ArrayList<>();
        }
        return blocks;
    }

    public void setBlocks(List<CertificationBlock> blocks) {
        this.blocks = blocks;
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public EfikaCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(EfikaCustomer customer) {
        this.customer = customer;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public FullTest getFulltest() {
        return fulltest;
    }

    public void setFulltest(FullTest fulltest) {
        this.fulltest = fulltest;
    }

}
