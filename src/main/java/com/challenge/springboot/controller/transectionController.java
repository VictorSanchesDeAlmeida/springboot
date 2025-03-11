package com.challenge.springboot.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class transectionController {

    @GetMapping("/transacao")
    public String getTransaction(){
        return "teste";
    }

}
