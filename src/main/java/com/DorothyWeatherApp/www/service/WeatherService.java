package com.DorothyWeatherApp.www.service;

import com.DorothyWeatherApp.www.entity.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

/*    @Value("${weather.api.url}")
    private String apiUrl;*/

    @Value("${weather.api.key}")
    private String apiKey;

    private String city;

    public Double getTemperature(String city) {
        //String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
         String url = UriComponentsBuilder.fromHttpUrl("http://api.openweathermap.org/data/2.5/weather")
                 .queryParam("q", city)
                 .queryParam("appid", apiKey)
                 .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        return response != null ? response.getMain().getTemp() : null;
    }

    public String getCity() {
        return city;
    }


}
