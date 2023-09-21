package com.ada.desafio.services;

import com.ada.desafio.entities.FeedbackEntity;
import com.ada.desafio.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
  final FeedbackRepository feedbackRepository;

  public FeedbackService(FeedbackRepository feedbackRepository) {
    this.feedbackRepository = feedbackRepository;
  }
  public FeedbackEntity save(FeedbackEntity feedback) {
    return feedbackRepository.save(feedback);
  }
}
