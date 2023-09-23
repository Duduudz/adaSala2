package com.ada.desafio.aws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TopicPublisher {

    private static final Logger LOG = LoggerFactory.getLogger(TopicPublisher.class);

    private final AmazonSNS snsClient;
    private final Topic topic;

    public TopicPublisher(AmazonSNS snsClient, @Qualifier("topic")Topic topic) {
        this.snsClient = snsClient;
        this.topic = topic;

    }

    public void publisherTopicEvent(String mensagem) {
        PublishResult publishResult = snsClient.publish(
                topic.getTopicArn(),
                mensagem
        );

        LOG.info("MessageId: {}", publishResult.getMessageId());
    }
}