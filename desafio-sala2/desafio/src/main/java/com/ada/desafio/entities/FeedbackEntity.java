package com.ada.desafio.entities;

import com.ada.desafio.entities.enums.FeedbackStatusEnum;
import com.ada.desafio.entities.enums.FeedbackTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private FeedbackTypeEnum type;
    private String message;
    private FeedbackStatusEnum status;
}
