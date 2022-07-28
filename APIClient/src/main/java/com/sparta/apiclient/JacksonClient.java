package com.sparta.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class JacksonClient {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ChuckObject result = mapper.readValue(
                    new URL("https://api.chucknorris.io/jokes/random"),
                    ChuckObject.class);
            System.out.println(result.getValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
