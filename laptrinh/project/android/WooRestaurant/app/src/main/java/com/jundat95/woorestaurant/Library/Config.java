package com.jundat95.woorestaurant.Library;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by jundat95 on 24/03/2016.
 */
public class Config {

    private static List<NameValuePair> keyPair = new ArrayList<NameValuePair>();

    public static List<NameValuePair> getKeyPair(){
        // Create Time Stamps
        int i = (int) (new Date().getTime() / 1000);
        String timeStamp = String.valueOf(i);
        // Ramdom nonce
        String nonce = UUID.randomUUID().toString().replaceAll("-", "");
        keyPair.add(new BasicNameValuePair("oauth_consumer_key", "ck_b4cb6e7394882f5af4b2f8dcc7145b614150989f"));
        keyPair.add(new BasicNameValuePair("oauth_timestamp", timeStamp));
        keyPair.add(new BasicNameValuePair("oauth_nonce", nonce));
        keyPair.add(new BasicNameValuePair("oauth_signature", "525c91b0eb8a7ad2815d16217eafdfd928d2081a"));
        keyPair.add(new BasicNameValuePair("oauth_signature_method", "HMAC-SHA1"));

        return keyPair;

    }
}
