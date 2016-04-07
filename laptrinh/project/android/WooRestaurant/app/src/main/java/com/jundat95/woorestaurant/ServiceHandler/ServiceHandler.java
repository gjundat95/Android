package com.jundat95.woorestaurant.ServiceHandler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by jundat95 on 14/03/2016.
 */
public class ServiceHandler {

    static String response = null;
    public static final int GET  = 1;
    public static final int POST = 2;
    public ServiceHandler() {
    }

    /**
     * Goi toi service
     * @param url Truyen vao url web
     * @param method Kieu thuc hien get hoac post
     * @return
     */
    public String makeServiceCall(String url, int method) {return this.makeServiceCall(url, method, null);}

    /**
     * Xu ly Khi goi toi webservice
     * @param url Duong dan toi trang web
     * @param method Phuong thuc Request GET=1 or POST=2
     * @param params Truyen vao cac keypair VD:?key=1234
     * @return
     */
    public String makeServiceCall(String url, int method, List<NameValuePair> params){

        try {
            // Http
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;

            // Kiem tra xem phai la phuong thuc POST hay khong
            if (method == POST) {
                HttpPost httpPost = new HttpPost(url);
                // kiem tra truyen params
                if (params != null) {
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                }
                httpResponse = httpClient.execute(httpPost);
            }else if(method == GET){

                if(params != null){
                    String paramString = URLEncodedUtils.format(params, "utf-8");
                    url+= "?"+paramString;
                }
                HttpGet httpGet = new HttpGet(url);
                httpResponse = httpClient.execute(httpGet);
            }
            httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


}
