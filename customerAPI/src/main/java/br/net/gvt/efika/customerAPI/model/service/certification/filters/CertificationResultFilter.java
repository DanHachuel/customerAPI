/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.customerAPI.model.service.certification.filters;

import br.net.gvt.efika.customer.model.certification.enums.CertificationResult;
import java.util.List;

public class CertificationResultFilter {

    public static CertificationResult getByEnum(List<CertificationResult> list, CertificationResult name) {
        for (CertificationResult valid : list) {
            if (valid == name) {
                return valid;
            }
        }
        return null;
    }
}
