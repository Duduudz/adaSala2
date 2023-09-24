package com.ada.desafio.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.SnsClientBuilder;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
public class SnsService {
  @Value("${aws.accessKeyId}")
  private String accessKeyId;

  @Value("${aws.secretAccessKey}")
  private String secretAccessKey;

  @Value("${aws.sns.topic.feedbacks.critica.arn}")
  private String feedbacksCriticaTopic;

  @Value("${aws.sns.topic.feedbacks.elogio.arn}")
  private String feedbacksElogioTopic;

  @Value("${aws.sns.topic.feedbacks.sugestao.arn}")
  private String feedbacksSugestaoTopic;

  private SnsClient getSnsClient() {
    SnsClientBuilder builder = SnsClient.builder();
    builder.region(Region.US_EAST_1);

    StaticCredentialsProvider awsCredentials = StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKeyId, secretAccessKey));

    return builder.credentialsProvider(awsCredentials).build();
  }

  public String publishFeedbackCriticaTopic(String message) {
    SnsClient snsClient = getSnsClient();
    String criticaMessageGroupId = "FeedbackCriticaFIFOGroup";

    PublishRequest request = PublishRequest.builder()
            .targetArn(feedbacksCriticaTopic)
            .message(message)
            .messageGroupId(criticaMessageGroupId)
            .build();
    PublishResponse result = snsClient.publish(request);
    return result.messageId();
  }

  public String publishFeedbackElogioTopic(String message) {
    SnsClient snsClient = getSnsClient();
    String elogioMessageGroupId = "FeedbackElogioFIFOGroup";

    PublishRequest request = PublishRequest.builder()
            .targetArn(feedbacksElogioTopic)
            .message(message)
            .messageGroupId(elogioMessageGroupId)
            .build();
    PublishResponse result = snsClient.publish(request);

    return result.messageId();
  }

  public String publishFeedbackSugestaoTopic(String message) {
    SnsClient snsClient = getSnsClient();
    String sugestaoMessageGroupId = "FeedbackSugestaoFIFOGroup";

    PublishRequest request = PublishRequest.builder()
            .targetArn(feedbacksSugestaoTopic)
            .message(message)
            .messageGroupId(sugestaoMessageGroupId)
            .build();
    PublishResponse result = snsClient.publish(request);

    return result.messageId();
  }
}
