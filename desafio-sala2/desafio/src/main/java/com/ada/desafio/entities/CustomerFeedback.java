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
public class CustomerFeedback {

    private UUID id;
    private FeedbackTypeEnum type;
    private String message;
    private FeedbackStatusEnum status;

    public CustomerFeedback(FeedbackTypeEnum type, String message, FeedbackStatusEnum status) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.message = message;
        this.status = "Recebido";
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FeedbackTypeEnum getType() {
        return type;
    }

    public void setType(FeedbackTypeEnum type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FeedbackStatusEnum getStatus() {
        return status;
    }

    public void setStatus(FeedbackStatusEnum status) {
        this.status = status;
    }
}
