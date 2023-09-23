package com.ada.desafio.services;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.Topic;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class FeedbackCriticaPublisher {
//  private static final Logger LOG = (Logger) LoggerFactory.getLogger(FeedbackCriticaPublisher.class);

  private final AmazonSNS snsClient;
  private final Topic feedbacksCriticaTopic;

  public FeedbackCriticaPublisher(AmazonSNS snsClient, @Qualifier("feedbacksCriticaTopic") Topic feedbacksCriticaTopic) {
    this.snsClient = snsClient;
    this.feedbacksCriticaTopic = feedbacksCriticaTopic;
  }

  public String publishFeedbackCritica(String message) {
    PublishResult publishResult = snsClient.publish(
            feedbacksCriticaTopic.getTopicArn(),
            message
    );

//    LOG.info("MessageId: " + publishResult.getMessageId());
    return publishResult.getMessageId();
  }

}
