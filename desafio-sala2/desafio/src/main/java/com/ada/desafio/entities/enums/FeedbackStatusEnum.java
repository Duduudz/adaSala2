package com.ada.desafio.entities.enums;

public enum FeedbackStatusEnum {
    RECEBIDO("Recebido"),
    EM_PROCESSAMENTO("Em processamento"),
    FINALIZADO("Finalizado");

    private String message;

    FeedbackStatusEnum(String message) { this.message = message; }

    public String getTypeMessage() { return message; }

}
