package com.traveather.weather.integrator.model;

import lombok.Data;

@Data
public class Current {
    private String last_updated;
    private double temp_c;
    private Condition condition;
    private double wind_kph;
}
