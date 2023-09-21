package com.bootcamp.cielo.sqsintegration.adapter.gateway.aws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class SQSProducer {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    private static final Logger LOG = LoggerFactory.getLogger(SQSProducer.class);

    public void sendMessage(String message) {
        LOG.info("[PRODUCER] Sending Message to SQS. Message: {}", message);
        queueMessagingTemplate.convertAndSend(endpoint, message);
    }
}
