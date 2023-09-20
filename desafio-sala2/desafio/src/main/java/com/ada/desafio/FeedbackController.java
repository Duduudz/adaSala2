package com.ada.desafio;

import com.ada.desafio.entities.CustomerFeedback;
import com.ada.desafio.enums.TypeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/feedback")
public class FeedbackController {
    @GetMapping
    public CustomerFeedback getInfoFeedback(){

        //TODO CLASSE DE IMPLEMENTACAO PRA TESTE EXEMPLO DE CHAMADA http://localhost:8080/feedback

        CustomerFeedback feedback = new CustomerFeedback();

        feedback.setId("1");
        feedback.setType("CRITICA");
        feedback.setMessage("teste");

        return feedback;
    }

}
