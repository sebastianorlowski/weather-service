package com.traveather.weather.integrator.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherIntegratorListenerConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queues.weather-integrator}")
    private String weatherIntegratorQueue;

    @Value("${rabbitmq.routing-keys.internal-weather-integrator")
    private String weatherRoutingKey;

    @Value("${rabbitmq.uri}")
    private String rabbitMQUri;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(this.internalExchange);
    }

    @Bean
    public Queue queue() {
        return new Queue(this.weatherIntegratorQueue);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with(this.weatherRoutingKey);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUri(rabbitMQUri);
        return connectionFactory;
    }

    @Bean
    public AmqpTemplate amqpTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setMessageConverter(messageConverter());
        return template;
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
