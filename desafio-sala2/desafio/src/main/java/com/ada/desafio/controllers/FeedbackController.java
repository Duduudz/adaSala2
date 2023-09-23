package com.ada.desafio.controllers;

import com.ada.desafio.aws.TopicPublisher;
import com.ada.desafio.entities.CustomeFeedback;
import com.ada.desafio.entities.enums.FeedbackStatusEnum;
import com.ada.desafio.repositories.FeedbackRepository;
import com.ada.desafio.services.FeedbackService;
import org.springframework.beans.BeanUtils;
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

  private final TopicPublisher topicPublisher;

  FeedbackController(FeedbackRepository repository) {
    this.repository = repository;
  }

  FeedbackController(TopicPublisher topicPublisher) {
    this.topicPublisher = topicPublisher;
  }

  @GetMapping("/sugestao")
  public ResponseEntity<List<CustomeFeedback>> getSuggestionFeedbacks() {
    // TODO - Precisa filtrar somente feedbacks de sugestao
    try {
      List<CustomeFeedback> suggestionFeedbackList = new ArrayList<>();
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
  public ResponseEntity<List<CustomeFeedback>> getPraiseFeedbacks(){
    // TODO - Precisa filtrar somente feedbacks de elogio
    try {
      List<CustomeFeedback> praiseFeedbackList = new ArrayList<>();
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
  public ResponseEntity<List<CustomeFeedback>> getCriticizeFeedbacks(){
    // TODO - Precisa filtrar somente feedbacks de criticas
    try {
      List<CustomeFeedback> criticizeFeedbackList = new ArrayList<>();
      feedbackService.getAllSuggestionFeedbacks().forEach(criticizeFeedbackList::add);

      if (criticizeFeedbackList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return ResponseEntity.status(HttpStatus.OK).body(criticizeFeedbackList);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping()
  public ResponseEntity<Object> saveFeedback(@RequestBody CustomeFeedback feedback) {
    var feedbackEntity = new CustomeFeedback();
    BeanUtils.copyProperties(feedback, feedbackEntity);
    feedbackEntity.setStatus(String.valueOf(FeedbackStatusEnum.RECEBIDO));

    CustomeFeedback savedFeedback = feedbackService.save(feedbackEntity);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedFeedback);
  }

  @GetMapping("/feedbacks")
  List<CustomeFeedback> all() {
    return  repository.findAll();
  }

  @PostMapping("/feedback")
  CustomeFeedback newFeedbackEntity(@RequestBody CustomeFeedback newCustomeFeedback) {
    return repository.save(newCustomeFeedback);
  }

  @PostMapping("/awstest")
  TopicPublisher topicPublisher(@RequestBody CustomeFeedback newCustomeFeedback){
    return this.topicPublisher(SnsConfig snsConfig, newCustomeFeedback.getType());
  }

}
