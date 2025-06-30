package com.DorothyWeatherApp.www.controller;

import com.DorothyWeatherApp.www.entity.WeatherResponse;
import com.DorothyWeatherApp.www.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

// get temperature details with city name
    @GetMapping("/temperature")
    public String getTemperature(@RequestParam String city) {
        Double temp = weatherService.getTemperature(city);
        return temp != null ? String.format("Current temperature in %s is %.2f°C", weatherService.getCity(), temp) : "Temperature data not available.";
    }

 /*   @GetMapping("/{city}")
    public WeatherResponse getWeather(@PathVariable String city) {
        return weatherService.getWeather(city);
    }*/
}
