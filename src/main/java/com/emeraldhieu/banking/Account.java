package com.emeraldhieu.banking;

/**
 * Abstract bank account class.<br>
 * <br>
 * <p>
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account implements AccountInterface {
    private final AccountHolder accountHolder;
    private final Long accountNumber;
    private final int pin;
    private double balance;

    protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = startingDeposit;
    }

    @Override
    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    @Override
    public boolean validatePin(int attemptedPin) {
        return pin == attemptedPin;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public Long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void creditAccount(double amount) {
        balance += amount;
    }

    @Override
    public boolean debitAccount(double amount) {
        if (balance - amount < 0) {
            return false;
        }
        balance = balance - amount;
        return true;
    }
}
