package com.DorothyWeatherApp.www.service;

import com.DorothyWeatherApp.www.entity.GeocodingResponse;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingService {

@Value("${weather.api.key}")
    private String apiKey;
  /*  private final RestTemplate restTemplate;

    public GeocodingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    public List<GeocodingResponse> getGeocodingData(String city) {
        try{
        URI url = UriComponentsBuilder.fromHttpUrl("http://api.openweathermap.org/geo/1.0/direct")
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .build()
                .encode()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
      //  String rawResponse = restTemplate.getForObject(url,String.class);
      //  System.out.println("Raw Response is : " +rawResponse);
        GeocodingResponse[] response = restTemplate.getForObject(url, GeocodingResponse[].class);
        return Arrays.asList(response);
        } catch (Exception e) {
            throw new RuntimeException("Error while calling Geocoding API: " + e.getMessage(), e);
        }
    }

    public List<GeocodingResponse> getGeocodingDatabyZipcode(String zipcode){
        try{
            URI zipurl = UriComponentsBuilder.fromHttpUrl("http://api.openweathermap.org/geo/1.0/zip")
                    .queryParam("zip",zipcode)
                    .queryParam("appid",apiKey)
                    .build()
                    .toUri();
            RestTemplate restTemplate = new RestTemplate();
            String raw = restTemplate.getForObject(zipurl, String.class);
            System.out.println("Raw JSON: " + raw);
            GeocodingResponse response = restTemplate.getForObject(zipurl, GeocodingResponse.class);
            return Arrays.asList(response);
        } catch (Exception e) {
            throw new RuntimeException("Error while calling Geocoding API with zip code: " + e.getMessage(), e);
        }

    }
}

