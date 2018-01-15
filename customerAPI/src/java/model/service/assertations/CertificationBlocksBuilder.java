/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import br.net.gvt.efika.customer.EfikaCustomer;
import java.util.List;
import model.service.certification.impl.CertificationBlock;

/**
 *
 * @author G0041775
 */
public interface CertificationBlocksBuilder {

    public List<CertificationBlock> buildAsserts(EfikaCustomer ec) throws Exception;

}
