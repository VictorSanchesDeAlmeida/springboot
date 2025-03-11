package com.challenge.springboot.model;

import java.time.OffsetDateTime;

public class Transaction {

    private double value;
    private OffsetDateTime date;

    public Transaction(){}

    public Transaction(double value, OffsetDateTime date) {
        this.value = value;
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }
}
