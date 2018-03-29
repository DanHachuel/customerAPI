/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.dao.certification;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import java.util.List;
import br.net.gvt.efika.customerAPI.model.entity.CustomerCertification;
import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;
import br.net.gvt.efika.mongo.dao.MongoEndpointEnum;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.FindOptions;

/**
 *
 * @author G0041775
 */
public class CertificationDAOImpl extends AbstractMongoDAO<CustomerCertification> implements CertificationDAO {

    public CertificationDAOImpl() {
        super(MongoEndpointEnum.MONGO.getIp(), "customerAPI", CustomerCertification.class);
    }

    @Override
    public List<CustomerCertification> findByCustomer(EfikaCustomer cust) throws Exception {
        return getDatastore().createQuery(CustomerCertification.class)
                .field("customer.instancia")
                .equal(cust.getInstancia())
                .order("-dataFim")
                .asList(new FindOptions()
                        .limit(10));
    }

    @Override
    public CustomerCertification read(String id) throws Exception {
        return super.read(new ObjectId(id));
    }

    @Override
    public CustomerCertification findByFkId(String fkId) {
        CustomerCertification ret = null;
        try {
            ret = getDatastore().createQuery(CustomerCertification.class)
                    .field("fkId")
                    .equal(fkId).get();
        } catch (Exception e) {
        }

        return ret;
    }

}
