package com.sparta.apitests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiclient.ChuckObject;
import com.sparta.apiclient.WeatherObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.net.URL;

public class ChuckTest {

    @Test
    public void checkValueLength(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            ChuckObject result = mapper.readValue(
                    new URL("https://api.chucknorris.io/jokes/random"),
                    ChuckObject.class);
            Assertions.assertNotEquals(0, result.getValue().length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkCity(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            WeatherObject result = mapper.readValue(
                    new URL("https://api.openweathermap.org/data/2.5/weather?q=Birmingham,UK&appid=91302ec55ea1d638496b1cce86f4043a"),
                    WeatherObject.class);
            Assertions.assertEquals("Birmingham", result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkTemperature(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            WeatherObject result = mapper.readValue(
                    new URL("https://api.openweathermap.org/data/2.5/weather?q=Birmingham,UK&appid=91302ec55ea1d638496b1cce86f4043a"),
                    WeatherObject.class);
            double temperature = result.getMain().getTemp();
            Assertions.assertTrue(temperature > 273);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
