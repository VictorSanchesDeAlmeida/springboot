package com.challenge.springboot.service;


import com.challenge.springboot.model.Statistic;
import org.springframework.stereotype.Service;
import com.challenge.springboot.model.Transaction;

import java.time.OffsetDateTime;
import java.util.*;

@Service
public class TransactionService {

    private final List<Transaction> listTransaction = new ArrayList<>();

    public void addTransaction(Transaction newTransaction){

        listTransaction.add(newTransaction);

    }

    public void deleteAllTransaction(){
        listTransaction.clear();
    }

    public Statistic getTransactionLast60s(){

        OffsetDateTime dateNow = OffsetDateTime.now();

        List<Transaction> filteredTransactions = listTransaction.stream()
                .filter(transaction -> transaction.getDate().isAfter(dateNow.minusSeconds(60)))
                .toList();

        int count = filteredTransactions
                .size();

        double sum = filteredTransactions.stream()
                .mapToDouble(Transaction::getValue)
                .sum();

        double min = filteredTransactions.stream()
                .min(Comparator.comparingDouble(Transaction::getValue))
                .map(Transaction::getValue)
                .orElse(0.00);

        double max = filteredTransactions.stream()
                .max(Comparator.comparingDouble(Transaction::getValue))
                .map(Transaction::getValue)
                .orElse(0.00);

        double avg = count > 0 ? sum / count : 0;

        return new Statistic(count, sum, avg, min, max);
    }

    public List<Transaction> getAllListTransaction(){
        return listTransaction;
    }

}
