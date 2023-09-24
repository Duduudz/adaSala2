package com.ada.desafio.controllers;

import com.ada.desafio.entities.CustomerFeedback;
import com.ada.desafio.repositories.FeedbackRepository;
import com.ada.desafio.services.FeedbackService;
import com.ada.desafio.services.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/feedback")
public class FeedbackController {
  @Autowired
  private FeedbackService feedbackService;

  private final FeedbackRepository repository;

  private final SnsService snsService;

  @Autowired
  FeedbackController(SnsService snsService, FeedbackRepository repository) {
    this.snsService = snsService;
    this.repository = repository;
  }

  @GetMapping("/sugestao")
  public ResponseEntity<List<CustomerFeedback>> getSuggestionFeedbacks() {
    // TODO - Precisa filtrar somente feedbacks de sugestao
    try {
      List<CustomerFeedback> suggestionFeedbackList = new ArrayList<>();
      feedbackService.getAllSuggestionFeedbacks().forEach(suggestionFeedbackList::add);

      if (suggestionFeedbackList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return ResponseEntity.status(HttpStatus.OK).body(suggestionFeedbackList);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/elogio")
  public ResponseEntity<List<CustomerFeedback>> getPraiseFeedbacks(){
    // TODO - Precisa filtrar somente feedbacks de elogio
    try {
      List<CustomerFeedback> praiseFeedbackList = new ArrayList<>();
      feedbackService.getAllSuggestionFeedbacks().forEach(praiseFeedbackList::add);

      if (praiseFeedbackList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return ResponseEntity.status(HttpStatus.OK).body(praiseFeedbackList);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/critica")
  public ResponseEntity<List<CustomerFeedback>> getCriticizeFeedbacks(){
    // TODO - Precisa filtrar somente feedbacks de criticas
    try {
      List<CustomerFeedback> criticizeFeedbackList = new ArrayList<>();
      feedbackService.getAllSuggestionFeedbacks().forEach(criticizeFeedbackList::add);

      if (criticizeFeedbackList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return ResponseEntity.status(HttpStatus.OK).body(criticizeFeedbackList);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @GetMapping("/feedbacks")
  List<CustomerFeedback> all() {
    return  repository.findAll();
  }

  @PostMapping()
  String addNewFeedback(@RequestBody CustomerFeedback newCustomerFeedback) {
    String feedbackType = newCustomerFeedback.getType();
    String feedbackMessage = newCustomerFeedback.getMessage();

    return switch (feedbackType) {
      case "CRITICA" -> {
        repository.save(newCustomerFeedback);
        yield snsService.publishFeedbackCriticaTopic((feedbackMessage));
      }
      case "ELOGIO" -> {
        repository.save(newCustomerFeedback);
        yield snsService.publishFeedbackElogioTopic((feedbackMessage));
      }
      case "SUGESTAO" -> {
        repository.save(newCustomerFeedback);
        yield snsService.publishFeedbackSugestaoTopic((feedbackMessage));
      }
      default -> "O tipo de feedback deve ser 'CRITICA', 'ELOGIO' ou 'SUGESTAO'";
    };
  };
}
