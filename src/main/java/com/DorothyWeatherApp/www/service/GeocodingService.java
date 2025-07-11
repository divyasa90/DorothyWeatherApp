package com.DorothyWeatherApp.www.service;

import com.DorothyWeatherApp.www.entity.GeocodingResponse;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingService {

@Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GeocodingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GeocodingResponse> getGeocodingData(String cityName) {
        String url = UriComponentsBuilder.fromHttpUrl("http://api.openweathermap.org/geo/1.0/direct")
                .queryParam("q", cityName)
                .queryParam("appid", apiKey)
                .toUriString();

        GeocodingResponse[] response = restTemplate.getForObject(url, GeocodingResponse[].class);
        return Arrays.asList(response);
    }


}
