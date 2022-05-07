package com.emeraldhieu.banking;

public class ConsumerAccount extends Account {
    public ConsumerAccount(Person person, Long accountNumber, int pin, double currentBalance) {
        super(person, accountNumber, pin, currentBalance);
    }
}
