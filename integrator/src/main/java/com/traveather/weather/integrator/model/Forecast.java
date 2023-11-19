package com.traveather.weather.integrator.model;

import lombok.Data;

import java.util.List;

@Data
public class Forecast {

    public List<Forecastday> forecastday;
}
