package com.ada.desafio.services;

import com.ada.desafio.entities.FeedbackEntity;
import com.ada.desafio.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
  @Autowired
  private FeedbackRepository feedbackRepository;

  public FeedbackEntity save(FeedbackEntity feedback) {
    return feedbackRepository.save(feedback);
  }
  public List<FeedbackEntity> getAllSuggestionFeedbacks() {
    return feedbackRepository.findAll();
  }
}
