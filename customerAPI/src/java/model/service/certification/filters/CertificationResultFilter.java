/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.certification.filters;

import java.util.List;
import model.service.certification.enums.CertificationResult;

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
