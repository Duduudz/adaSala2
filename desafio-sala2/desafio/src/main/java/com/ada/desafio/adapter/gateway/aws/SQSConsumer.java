package com.ada.desafio.adapter.gateway.aws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SQSConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(SQSConsumer.class);

    @SqsListener("${cloud.aws.end-point.uri}")
    public void receiveMessage(String message){
        LOG.info("[CONSUMER] Message received: {}", message);
    }

}
