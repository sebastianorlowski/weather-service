package com.traveather.weather.integrator.model;

import lombok.Data;

@Data
public class Root {
    private Location location;
    private Current current;
    private Forecast forecast;
}
