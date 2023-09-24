package com.ada.desafio.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSqsConfig {

  @Value("${aws.accessKeyId}")
  private String accessKeyId;

  @Value("${aws.secretAccessKey}")
  private String secretAccessKey;

  @Value("${aws.region}")
  private String region;

  @Bean
  public AmazonSQS sqsClient() {

    AmazonSQSClientBuilder builder = AmazonSQSClientBuilder.standard();

    if ((region != null) && !region.isEmpty()) {
      builder = builder.withRegion(region);
    }

    if ((accessKeyId != null) && !accessKeyId.isEmpty() && (secretAccessKey != null) && !secretAccessKey.isEmpty()) {
      BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
      builder = builder.withCredentials(new AWSStaticCredentialsProvider(awsCredentials));
    }

    return builder.build();
  }
}

