package com.emeraldhieu.banking;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void creditAccountConcurrently() throws InterruptedException {
        // GIVEN
        int numberOfThreads = 100000;
        double expense = 1;
        double balance = 10.0;

        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        Person person = new Person("John", "Doe", 123);
        PersonalAccount personalAccount = new PersonalAccount(person, 456L, 123456789, balance);

        // WHEN
        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                personalAccount.creditAccount(expense);
                latch.countDown();
            });
        }
        latch.await();

        // THEN
        assertEquals(expense * numberOfThreads + balance, personalAccount.getBalance());
    }

    @Test
    public void debitAccountConcurrently() throws InterruptedException {
        // GIVEN
        int numberOfThreads = 100000;
        double expense = 1;
        double balance = numberOfThreads * expense;
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        Person person = new Person("John", "Doe", 123);
        PersonalAccount personalAccount = new PersonalAccount(person, 456L, 123456789, balance);

        // WHEN
        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                personalAccount.debitAccount(expense);
                latch.countDown();
            });
        }
        latch.await();

        // THEN
        assertEquals(balance - expense * numberOfThreads, personalAccount.getBalance());
    }

    private class PersonalAccount extends Account {
        public PersonalAccount(Person person, Long accountNumber, int pin, double currentBalance) {
            super(person, accountNumber, pin, currentBalance);
        }
    }
}