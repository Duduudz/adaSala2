package com.ada.desafio.controllers;

import com.ada.desafio.dtos.FeedbackDto;
import com.ada.desafio.entities.FeedbackEntity;
import com.ada.desafio.entities.enums.FeedbackStatusEnum;
import com.ada.desafio.entities.enums.FeedbackTypeEnum;
import com.ada.desafio.services.FeedbackService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/feedback")
public class FeedbackController {

  final FeedbackService feedbackService;

  public FeedbackController(FeedbackService feedbackService) {
      this.feedbackService = feedbackService;
  }
  @GetMapping
  public FeedbackEntity getInfoFeedback(){
    FeedbackEntity feedback = new FeedbackEntity();

    feedback.setId(1);
    feedback.setType(FeedbackTypeEnum.CRITICA);
    feedback.setMessage("teste");
    feedback.setStatus(FeedbackStatusEnum.RECEBIDO);

    return feedback;
  }

  @PostMapping
  public ResponseEntity<Object> saveSuggestionFeedback(@RequestBody FeedbackDto feedbackDto) {
    var feedbackEntity = new FeedbackEntity();
    BeanUtils.copyProperties(feedbackDto, feedbackEntity);
    feedbackEntity.setStatus(FeedbackStatusEnum.RECEBIDO);

    return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.save(feedbackEntity));
  }
}
