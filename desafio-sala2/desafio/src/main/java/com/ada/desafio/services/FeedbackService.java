package com.ada.desafio.services;

import com.ada.desafio.adapter.gateway.aws.SQSProducer;
import com.ada.desafio.entities.FeedbackEntity;
import com.ada.desafio.repositories.FeedbackRepository;
import com.amazonaws.services.sns.model.PublishRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

  private final String TOPIC_ARN = "arn:aws:sns:us-east-1:841454975235:FeedbackSugestion.fifo";


  @Autowired
  private FeedbackRepository feedbackRepository;

  @Autowired
  private SQSProducer sqsproducer;

  public void publishMessageToSnsTopic(FeedbackEntity mensagem) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    String topico = "sugestao";

    PublishRequest publishRequest = new PublishRequest()
            .withTopicArn(TOPIC_ARN)
            .withMessage(objectMapper.writeValueAsString(mensagem))
            .withMessageDeduplicationId(mensagem.getId().toString())
            .withMessageGroupId(topico + "841454975235");
    sqsproducer.sendMessage(topico);


  }

  public FeedbackEntity save(FeedbackEntity feedback) {
    return feedbackRepository.save(feedback);
  }
  public List<FeedbackEntity> getAllSuggestionFeedbacks() {
    return feedbackRepository.findAll();
  }
}
