package com.ada.desafio.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.Topic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnsConfig {
  @Value("${aws.region}")
  private String awsRegion;

  @Value("${aws.sns.topic.feedbacks.critica.arn}")
  private String feedbacksCriticaTopic;

  @Value("${aws.sns.topic.feedbacks.elogio.arn}")
  private String feedbacksElogioTopic;

  @Value("${aws.sns.topic.feedbacks.sugestao.arn}")
  private String feedbacksSugestaoTopic;

  @Bean
  @Qualifier("feedbacksCriticaTopic")
  public Topic feedbacksCriticaTopic() {
    // Define and configure your Topic bean here
    // For example:
     Topic topic = new Topic();
     topic.setTopicArn(feedbacksCriticaTopic);
     return topic;
  }

  @Bean
  public AmazonSNS snsClient() {
    return AmazonSNSClientBuilder.standard()
            .withRegion(awsRegion)
            .withCredentials(new DefaultAWSCredentialsProviderChain())
            .build();
  }

  @Bean
  public Topic snsFeedbacksCriticaTopic() {
    return new Topic().withTopicArn(feedbacksCriticaTopic);
  }

  @Bean
  public Topic snsFeedbacksElogioTopic() {
    return new Topic().withTopicArn(feedbacksElogioTopic);
  }

  @Bean
  public Topic snsFeedbacksSugestaoTopic() {
    return new Topic().withTopicArn(feedbacksSugestaoTopic);
  }
};

