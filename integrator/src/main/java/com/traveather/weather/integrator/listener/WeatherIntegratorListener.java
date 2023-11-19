package com.traveather.weather.integrator.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class WeatherIntegratorListener {

    @RabbitListener(queues = { "${rabbitmq.queues.weather-integrator}" })
    public void receiveMessage(final Message<String> message) {
    }
}
