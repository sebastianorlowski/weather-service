package com.traveather.weather.integrator.config;

import com.traveather.weather.integrator.model.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherIntegratorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherIntegratorService.class);

    @Value("${weather-api.url}")
    private String WEATHER_API_URL;

    @Value("${weather-api.api-key}")
    private String API_KEY;

    private WebClient webClient;

    public WeatherIntegratorService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Root> retrieveWeatherForecast(String city) {
        final String weatherForecastUri = String.format(
                "%sforecast.json?key=%s&q=%s&days=1&aqi=no&alerts=no",
                WEATHER_API_URL, API_KEY, city);

        return retrieveData(weatherForecastUri);
    }

    public Mono<Root> retrieveCityName(String coordinates) {
        String[] array = coordinates.split(",");
        double latitude = Double.parseDouble(array[0]);
        double longitude = Double.parseDouble(array[1]);

        final String weatherForecastUri = String.format(
                "%sforecast.json?key=%s&q=%s,%s&days=1&aqi=no&alerts=no",
                WEATHER_API_URL, API_KEY, latitude, longitude);

        return retrieveData(weatherForecastUri);
    }

    private Mono<Root> retrieveData(String sourceUri) {
        return webClient.get()
                .uri(sourceUri)
                .retrieve()
                .bodyToMono(Root.class)
                .doOnError(error -> LOGGER.error("Cannot parse message to body", error));
    }
}
