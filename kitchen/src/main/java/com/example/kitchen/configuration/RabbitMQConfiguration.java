package com.example.kitchen.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class RabbitMQConfiguration implements RabbitListenerConfigurer {

  @Bean
  @Qualifier("orderExchange")
  public TopicExchange orderExchange(@Value("${order.exchange.name}") String orderExchangeName) {
    return new TopicExchange(orderExchangeName);
  }

  @Bean
  @Qualifier("orderQueue")
  public Queue orderCreatedQueue(@Value("${order.queue}") String queueName) {
    return new Queue(queueName, true);
  }

  @Bean
  @Qualifier("orderCreatedBinding")
  public Binding orderCreatedBinding(Queue orderCreatedQueue, TopicExchange orderExchange,
      @Value("${order.anything.binding-key}") String bindingKey) {
    return BindingBuilder
        .bind(orderCreatedQueue)
        .to(orderExchange)
        .with(bindingKey);
  }

  @Bean
  public MappingJackson2MessageConverter consumerConverter() {
    return new MappingJackson2MessageConverter();
  }

  @Bean
  public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
    var factory = new DefaultMessageHandlerMethodFactory();
    factory.setMessageConverter(consumerConverter());
    return factory;
  }

  @Override
  public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
    registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
  }
}
