package com.DorothyWeatherApp.www.controller;

import com.DorothyWeatherApp.www.entity.GeocodingResponse;
import com.DorothyWeatherApp.www.service.GeocodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("geo/1.0/direct")
public class GeocodingAPI {

    @Autowired
    public GeocodingService geocodingService;

    //get coordinates with city name
    @GetMapping("/coordinates")
    public List<GeocodingResponse> getCoordinatesbyCityName(@RequestParam String city){
        return geocodingService.getGeocodingData(city);
    }
}
