/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import io.swagger.model.enums.SystemEnum;
import java.util.Locale;

/**
 *
 * @author G0041775
 */
public class FactoryLocale {

    public static Locale createLocale(SystemEnum system) {
        Locale l = new Locale("co", "CO");
        try {
            switch (system) {
                case URA:
                    l = new Locale("ext", "CAMPO");
                    break;
                case APP:
                    l = new Locale("ext", "CAMPO");
                    break;
                case CRM:
                    l = new Locale("ext", "CRM");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
        }

        return l;
    }

}
