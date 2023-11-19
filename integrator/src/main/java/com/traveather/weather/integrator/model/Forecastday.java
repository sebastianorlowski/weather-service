package com.traveather.weather.integrator.model;

import lombok.Data;

import java.util.List;

@Data
public class Forecastday {

    private String date;
    private int date_epoch;
    private Day day;
    private Astro astro;
    private List<Hour> hour;
}
