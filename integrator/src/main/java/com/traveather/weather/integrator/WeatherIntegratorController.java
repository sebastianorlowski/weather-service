package com.traveather.weather.integrator;

import com.traveather.weather.integrator.config.WeatherIntegratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherIntegratorController {

    private WeatherIntegratorService weatherIntegratorService;

    public WeatherIntegratorController(WeatherIntegratorService weatherIntegratorService) {
        this.weatherIntegratorService = weatherIntegratorService;
    }

    // Draft of controller TODO: create implementation to support openAPI & RabbitMQ approach

    @GetMapping("/weather")
    public Mono<?> retrieveWeatherForecast(@RequestParam String city) {
        return weatherIntegratorService.retrieveWeatherForecast(city);
    }

    @GetMapping("/weather/city")
    public Mono<?> retrieveCityName(@RequestParam String coordinates) {
        return weatherIntegratorService.retrieveCityName(coordinates);
    }
}
