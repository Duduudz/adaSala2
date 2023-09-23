package com.ada.desafio.services;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FeedbackCriticaPublisherService {
  private static final Logger LOG = (Logger) LoggerFactory.getLogger(FeedbackCriticaPublisherService.class);

  private final AmazonSNS snsClient;

  private final Topic feedbacksCriticaTopic;

  public FeedbackCriticaPublisherService(AmazonSNS snsClient, @Qualifier("feedbacksCriticaTopic") Topic feedbacksCriticaTopic) {
    this.snsClient = snsClient;
    this.feedbacksCriticaTopic = feedbacksCriticaTopic;
  }

  public String publishFeedbackCritica(String message) {
    PublishResult publishResult = snsClient.publish(
            feedbacksCriticaTopic.getTopicArn(),
            message
    );

    LOG.info("MessageId: " + publishResult.getMessageId());
    return publishResult.getMessageId();
  }

}
