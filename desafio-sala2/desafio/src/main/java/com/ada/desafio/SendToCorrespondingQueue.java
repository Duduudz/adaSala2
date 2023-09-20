package com.ada.desafio;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/feedback/postInQueue")
public class SendToCorrespondingQueue {
    @PostMapping
    public String SendToQueu(){
        String status = "Sucesso";

        //TODO Classe para implementacao da informacao na fila

        return status;
    }

}
