package com.ada.desafio.entities;

import com.ada.desafio.entities.enums.FeedbackStatusEnum;
import com.ada.desafio.entities.enums.FeedbackTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Feedbacks")
@NoArgsConstructor
@Getter
@Setter
public class CustomerFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String messageId;
    private String type;
    private String message;
    private String status;

    public CustomerFeedback(FeedbackTypeEnum type, FeedbackStatusEnum status, String message) {
        this.type = String.valueOf(type);
        this.status = String.valueOf(status);
        this.message = message;
    }
}
