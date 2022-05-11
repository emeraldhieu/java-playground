package com.emeraldhieu.banking;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private Map<Long, Account> accounts;

    // Just an incremental number.
    private AtomicLong number = new AtomicLong(1);

    public Bank() {
        accounts = new ConcurrentHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        Account account = accounts.get(accountNumber);
        return account;
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        long accountNumber = number.getAndIncrement();
        CommercialAccount account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        long accountNumber = number.getAndIncrement();
        ConsumerAccount consumerAccount = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, consumerAccount);
        return accountNumber;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).validatePin(pin);
        }
        throw new IllegalArgumentException("Account not found");
    }

    public double getBalance(Long accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).getBalance();
        }
        throw new IllegalArgumentException("Account not found");
    }

    public synchronized void credit(Long accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).creditAccount(amount);
            return;
        }
        throw new IllegalArgumentException("Account not found");
    }

    public synchronized boolean debit(Long accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).debitAccount(amount);
        }
        throw new IllegalArgumentException("Account not found");
    }
}
