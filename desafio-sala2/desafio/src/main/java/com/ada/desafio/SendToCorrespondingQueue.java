package com.ada.desafio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/feedback/postInQueue")
public class SendToCorrespondingQueue {
    @PostMapping
    public String SendToQueue(){
        return "success";
    }

    @GetMapping
    public String GetQueue() {
        return "Success";
    }

}
