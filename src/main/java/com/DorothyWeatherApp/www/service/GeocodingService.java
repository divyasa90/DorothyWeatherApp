package com.DorothyWeatherApp.www.service;

import com.DorothyWeatherApp.www.entity.GeocodingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeocodingService {

    @Autowired
    public GeocodingResponse geocodingResponse;


}
