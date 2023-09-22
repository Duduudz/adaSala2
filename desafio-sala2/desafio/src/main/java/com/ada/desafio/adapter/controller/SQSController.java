package com.ada.desafio.adapter.controller;

import com.ada.desafio.adapter.gateway.aws.SQSConsumer;
import com.ada.desafio.adapter.gateway.aws.SQSProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/queue")
public class SQSController {

    @Autowired
    private SQSProducer producer;

    @Autowired
    private SQSConsumer consumer;

    @PostMapping(value = "/{message}")
    public ResponseEntity<Void> sendMessage(@PathVariable(value = "message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok().build();
    }

}
