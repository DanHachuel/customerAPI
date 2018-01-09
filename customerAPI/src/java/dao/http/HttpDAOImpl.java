/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import util.JacksonMapper;

public class HttpDAOImpl implements HttpDAO {

    @Override
    public String get(String url, String contentType, Charset responseCharset) throws Exception {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        get.addHeader("Content-Type", contentType);

        HttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() != 200) {

            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }

        InputStreamReader reader;
        if (responseCharset != null) {
            reader = new InputStreamReader(response.getEntity().getContent(), responseCharset);
        } else {
            reader = new InputStreamReader(response.getEntity().getContent());
        }
        BufferedReader br = new BufferedReader(reader);

        String output;
        StringBuffer result = new StringBuffer();
        while ((output = br.readLine()) != null) {
            result.append(output);
        }

        httpClient.close();

        return result.toString();
    }

    @Override
    public String post(String url, Object obj, String contentType, Charset responseCharset) throws Exception {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", contentType);
        String json = new JacksonMapper(Object.class).serialize(obj);

        System.out.println("POST -> " + json);
        post.setEntity(new StringEntity(json));

        HttpResponse response = httpClient.execute(post);

        if (response.getStatusLine().getStatusCode() != 200) {

            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }
        InputStreamReader reader;
        if (responseCharset != null) {
            reader = new InputStreamReader(response.getEntity().getContent(), responseCharset);
        } else {
            reader = new InputStreamReader(response.getEntity().getContent());
        }
        BufferedReader br = new BufferedReader(reader);

        String output;
        StringBuffer result = new StringBuffer();
        while ((output = br.readLine()) != null) {
            result.append(output);
        }
        httpClient.close();

        return result.toString();
    }

}
