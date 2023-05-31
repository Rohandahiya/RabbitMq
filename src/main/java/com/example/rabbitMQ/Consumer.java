package com.example.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @RabbitListener(queues = {"${spring.rabbit.queue}"})
    public void consume(User value ){
        System.out.print("-------------" + value.toString());
    }

}
