package com.ada.desafio.entities.enums;

public enum FeedbackTypeEnum {
    SUGESTAO("Sugestao"),
    ELOGIO("Elogio"),
    CRITICA("Critica");

    private String type;

    FeedbackTypeEnum(String type){ this.type = type; }

    public String getType() { return type; }


    //TODO implementar o match com regex posteriormente se for o caso.
}
