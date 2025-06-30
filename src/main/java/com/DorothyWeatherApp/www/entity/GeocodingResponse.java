package com.DorothyWeatherApp.www.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeocodingResponse {
    private String name;
    private Double lat;
    private Double lon;
    private String country;
    private String state;
}
