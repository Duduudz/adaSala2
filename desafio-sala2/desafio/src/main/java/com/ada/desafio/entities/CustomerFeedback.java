package com.ada.desafio.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerFeedback {

    private String id;
    private String type;
    private String message;
    private String status;
}
