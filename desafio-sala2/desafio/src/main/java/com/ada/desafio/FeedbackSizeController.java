package com.ada.desafio;

import com.ada.desafio.entities.CustomerFeedback;
import com.ada.desafio.entities.FeedbackSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/feedback/size")
public class FeedbackSizeController {
    @GetMapping
    public FeedbackSize getFeedbackSize(){

        //TODO Podemos rever esse ponto e o retorno quando consumir da fila, apenas um exemplo para poder realizar testes

        FeedbackSize feedback = new FeedbackSize();

        feedback.setCritica(10);
        feedback.setElogio(20);
        feedback.setSugestao(30);
        feedback.setFilaTotal(60);

        return feedback;
    }
}
