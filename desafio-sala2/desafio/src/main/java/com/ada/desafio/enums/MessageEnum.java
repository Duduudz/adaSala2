package com.ada.desafio.enums;

public enum MessageEnum {
    RECEBIDO("Recebido"),
    EM_PROCESSAMENTO("Em processamento"),
    FINALIZADO("Finalizado");

    private String message;

    MessageEnum(String message) { this.message = message; }

    public String getTypeMessage() { return message; }

}
