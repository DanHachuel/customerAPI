/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.assertations;

import fulltest.FullTest;
import java.util.List;
import model.entity.CertificationBlock;

/**
 *
 * @author G0041775
 */
public interface CertificationBlocksBuilder {

    public List<CertificationBlock> buildAsserts(FullTest ft) throws Exception;

}
