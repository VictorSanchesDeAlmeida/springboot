package com.challenge.springboot.service;

import org.springframework.stereotype.Service;
import com.challenge.springboot.model.Transaction;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final List<Transaction> listTransaction = new ArrayList<>();

    public void addTransaction(Transaction newTransaction){

        listTransaction.add(newTransaction);

    }

    public List<Transaction> getAllListTransaction(){
        return listTransaction;
    }

}
