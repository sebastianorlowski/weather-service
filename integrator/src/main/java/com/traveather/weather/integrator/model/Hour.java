package com.traveather.weather.integrator.model;

import lombok.Data;

@Data
public class Hour {
    private int time_epoch;
    private String time;
    private double temp_c;
    private Condition condition;
    private int chance_of_rain;
    private int chance_of_snow;
}
