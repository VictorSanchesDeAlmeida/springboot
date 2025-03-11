package com.challenge.springboot.controller;

import com.challenge.springboot.model.Transaction;
import com.challenge.springboot.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transacao")
    public ResponseEntity<Void> getTransaction(@RequestBody Transaction transaction){

        if(transaction.getValue() <= 0){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        if(transaction.getDate().isAfter(OffsetDateTime.now())){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }


        transactionService.addTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/test")
    public List<Transaction> testTransaction(){

        return transactionService.getAllListTransaction();

    }

}
