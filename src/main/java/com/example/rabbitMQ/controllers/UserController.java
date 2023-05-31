package com.example.rabbitMQ.controllers;

import com.example.rabbitMQ.ProducerRabbitMQ;
import com.example.rabbitMQ.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private ProducerRabbitMQ producerRabbitMQ;

    @PostMapping("/set/user")
    public ResponseEntity<?> setUser(@RequestBody User user){
        producerRabbitMQ.sendUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("Added");
    }
}
