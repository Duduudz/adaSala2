package com.ada.desafio.controllers;

import com.ada.desafio.dtos.FeedbackDto;
import com.ada.desafio.entities.FeedbackEntity;
import com.ada.desafio.entities.enums.FeedbackStatusEnum;
import com.ada.desafio.entities.enums.FeedbackTypeEnum;
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

  @GetMapping("/sugestao")
  public ResponseEntity<List<FeedbackEntity>> getSuggestionFeedbacks() {
    // TODO - Precisa filtrar somente feedbacks de sugestao
    try {
      List<FeedbackEntity> suggestionFeedbackList = new ArrayList<>();
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
  public ResponseEntity<List<FeedbackEntity>> getPraiseFeedbacks(){
    // TODO - Precisa filtrar somente feedbacks de elogio
    try {
      List<FeedbackEntity> praiseFeedbackList = new ArrayList<>();
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
  public ResponseEntity<List<FeedbackEntity>> getCriticizeFeedbacks(){
    // TODO - Precisa filtrar somente feedbacks de criticas
    try {
      List<FeedbackEntity> criticizeFeedbackList = new ArrayList<>();
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
  public ResponseEntity<Object> saveFeedback(@RequestBody FeedbackEntity feedback) {
    var feedbackEntity = new FeedbackEntity();
    BeanUtils.copyProperties(feedback, feedbackEntity);
    feedbackEntity.setStatus(String.valueOf(FeedbackStatusEnum.RECEBIDO));

    FeedbackEntity savedFeedback = feedbackService.save(feedbackEntity);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedFeedback);
  }
}
