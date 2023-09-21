package com.ada.desafio.dtos;

import com.ada.desafio.entities.enums.FeedbackTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackDto {
  private FeedbackTypeEnum type;
  private String message;
}
