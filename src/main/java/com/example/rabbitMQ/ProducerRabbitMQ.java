package com.example.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ProducerRabbitMQ {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.rabbit.routingKey}")
    private String routingKey;

    @Value("${spring.rabbit.exchange}")
    private String exchange;

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }


    public void sendUser(User user){
        rabbitTemplate.convertAndSend(exchange,routingKey,user);
    }

}
