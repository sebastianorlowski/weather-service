package com.traveather.weather.integrator.model;

import lombok.Data;

@Data
public class Day {
    private double maxtemp_c;
    private double mintemp_c;
    private double avgtemp_c;
    private double maxwind_kph;
    private double totalsnow_cm;
    private double avghumidity;
    private int daily_chance_of_rain;
    private int daily_chance_of_snow;
    private Condition condition;
}
