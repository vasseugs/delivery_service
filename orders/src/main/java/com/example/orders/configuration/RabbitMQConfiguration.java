package com.example.orders.configuration;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

  @Bean
  public TopicExchange orderExchange(@Value("${order.exchange.name}") String exchangeName) {
    return new TopicExchange(exchangeName);
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    var rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(producerToJsonConverter());
    return rabbitTemplate;
  }

  @Bean
  public Jackson2JsonMessageConverter producerToJsonConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
