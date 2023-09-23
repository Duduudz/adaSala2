package com.ada.desafio.services;

import com.ada.desafio.entities.CustomeFeedback;
import com.ada.desafio.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
  @Autowired
  private FeedbackRepository feedbackRepository;

  public CustomeFeedback save(CustomeFeedback feedback) {
    return feedbackRepository.save(feedback);
  }
  public List<CustomeFeedback> getAllSuggestionFeedbacks() {
    return feedbackRepository.findAll();
  }
}
