/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;

/**
 *
 * @author G0042204
 */
public class GsonUtil {

    private Gson gson;

    public static Gson getGson() {
        return new Gson();
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public static String serialize(Object ob) {
        return getGson().toJson(ob, ob.getClass());
    }

}
