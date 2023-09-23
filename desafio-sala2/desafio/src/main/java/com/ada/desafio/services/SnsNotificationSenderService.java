package com.ada.desafio.services;

import com.amazonaws.services.sns.AmazonSNS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;

public class SnsNotificationSenderService {
  private final NotificationMessagingTemplate notificationMessagingTemplate;

  @Autowired
  public SnsNotificationSenderService(AmazonSNS amazonSns) {
    this.notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSns);
  }

  public void send(String subject, String message) {
    this.notificationMessagingTemplate.sendNotification("physicalTopicName", message, subject);
  }
}
