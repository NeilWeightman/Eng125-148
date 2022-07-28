package com.sparta.apiclient;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JSONSimpleClient {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.chucknorris.io/jokes/random");
            URLConnection conn = url.openConnection();
//            System.out.println(new BufferedReader(new InputStreamReader(conn.getInputStream())).readLine());
            JSONParser parser = new JSONParser();
            Object result = parser.parse(new InputStreamReader(conn.getInputStream()));
            JSONObject jsonObj = (JSONObject)result;
            System.out.println(jsonObj.get("value"));
            System.out.println(jsonObj.keySet());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
