package com.ada.desafio.services;

import com.ada.desafio.entities.CustomerFeedback;
import com.ada.desafio.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
  @Autowired
  private FeedbackRepository feedbackRepository;

  public CustomerFeedback save(CustomerFeedback feedback) {
    return feedbackRepository.save(feedback);
  }
  public List<CustomerFeedback> getAllSuggestionFeedbacks() {
    return feedbackRepository.findAll();
  }
}
