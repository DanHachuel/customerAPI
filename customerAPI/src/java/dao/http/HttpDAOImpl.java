/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import util.GsonUtil;

public class HttpDAOImpl implements HttpDAO {

    @Override
    public String get(String url, String contentType) throws Exception {
        URL leUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) leUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", contentType);

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        StringBuffer result = new StringBuffer();
        while ((output = br.readLine()) != null) {
            result.append(output);
        }

        conn.disconnect();

        return result.toString();
    }

    @Override
    public String post(String url, Object obj, String contentType) throws Exception {

        URL leUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) leUrl.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", contentType);

        String input = GsonUtil.serialize(obj);

        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());
        os.flush();

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;
        StringBuffer result = new StringBuffer();
        while ((output = br.readLine()) != null) {
            result.append(output);
        }

        conn.disconnect();

        return result.toString();
    }

}
