package com.emeraldhieu.banking;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HiddenTest {
    /**
     * The bank/
     */
    Bank bank;
    /**
     * The account number for john.
     */
    Long john;
    /**
     * The account number for julia
     */
    Long julia;

    /**
     * The account number for daniel
     */
    Long daniel;
    /**
     * The account number for bob
     */
    Long bob;
    /**
     * The account number for smith
     */
    Long smith;


    @BeforeEach
    public void setUp() throws Exception {
        bank = new Bank();
        Person person1john = new Person("john", "kennedy", 1);
        Person person2julia = new Person("julia", "singh", 2);
        Person person3daniel = new Person("daniel", "radcliffe", 3);
        Company company1bob = new Company("bob", 1);
        Company company2smith = new Company("smith", 2);
        john = bank.openConsumerAccount(person1john, 1111, 0.0);
        julia = bank.openConsumerAccount(person2julia, 2222, 456.78);
        daniel = bank.openConsumerAccount(person3daniel, 3333, 500.00);
        bob = bank.openCommercialAccount(company1bob, 1111, 0.0);
        smith = bank.openCommercialAccount(company2smith, 2222, 123456789.00);
    }

    @AfterEach
    public void tearDown() throws Exception {
        bank = null;
        john = null;
        julia = null;
        daniel = null;
        bob = null;
        smith = null;
    }

    @Test
    public void invalidAccountNumberTest() {
        assertTrue(john + 1 == julia, "1st and 2nd accounts were not assigned sequential account numbers.");
        assertTrue(julia + 1 == daniel, "2nd and 3rd accounts were not assigned sequential account numbers.");
        assertTrue(daniel + 1 == bob, "3rd and 4th accounts were not assigned sequential account numbers.");
        assertTrue(bob + 1 == smith, "4rd and 5th accounts were not assigned sequential account numbers.");

        assertEquals(bank.getBalance(john), 0.0, 0);
        assertEquals(bank.getBalance(julia), 456.78, 0);
        assertEquals(bank.getBalance(daniel), 500.00, 0);
        assertEquals(bank.getBalance(bob), 0.0, 0);
        assertEquals(bank.getBalance(smith), 123456789.00, 0);
        assertNotEquals(bank.getBalance(john), bank.getBalance(julia));
        assertNotEquals(bank.getBalance(john), bank.getBalance(daniel));
        assertNotEquals(bank.getBalance(bob), bank.getBalance(smith));
    }

    /**
     * Debit an account.
     */
    @Test
    public void debitTest() {
        double amount = 200.0;
        assertFalse(bank.debit(john, amount), "Account " + john + " should have insufficient funds.");
        assertTrue(bank.debit(julia, amount), "Account " + julia + " should have sufficient funds.");
        assertTrue(bank.debit(daniel, amount), "Account " + daniel + " should have sufficient funds.");
        assertFalse(bank.debit(bob, amount), "Account " + bob + " should have insufficient funds.");
        assertTrue(bank.debit(smith, amount), "Account " + smith + " should have sufficient funds.");
    }

    /**
     * Test crediting accounts inside {@link Bank}.
     */
    @Test
    public void bankCreditTest() {
        double amount = 500.00;
        double beforeDeposit1 = bank.getBalance(john);
        double beforeDeposit2 = bank.getBalance(julia);
        double beforeDeposit3 = bank.getBalance(daniel);
        double beforeDeposit4 = bank.getBalance(bob);
        double beforeDeposit5 = bank.getBalance(smith);
        bank.credit(john, amount);
        bank.credit(julia, amount);
        bank.credit(daniel, amount);
        bank.credit(bob, amount);
        bank.credit(smith, amount);
        assertEquals(beforeDeposit1 + amount, bank.getBalance(john), 0);
        assertEquals(beforeDeposit2 + amount, bank.getBalance(julia), 0);
        assertEquals(beforeDeposit3 + amount, bank.getBalance(daniel), 0);
        assertEquals(beforeDeposit4 + amount, bank.getBalance(bob), 0);
        assertEquals(beforeDeposit5 + amount, bank.getBalance(smith), 0);
    }

    /**
     * Tests {@link Transaction}: an attempt to access an account with an invalid PIN must throw an
     * Exception.
     */
    @Test
    public void invalidPinTransaction() {
        assertThrows(Exception.class, () -> {
            new Transaction(bank, john, 9999);
        });
    }

    /**
     * Tests {@link Transaction}
     *
     * @throws Exception Account validation failed.
     */
    @Test
    public void transactionTest() throws Exception {
        Transaction transaction1 = new Transaction(bank, daniel, 3333);
        double beforeDeposit1 = transaction1.getBalance();
        double amount = 1000000.23;
        transaction1.credit(amount);
        assertEquals(beforeDeposit1 + amount, transaction1.getBalance(), 0);
        assertTrue(transaction1.debit(amount), "Debit was unsuccessful.");
        assertFalse(transaction1.debit(amount), "This transaction should have overdrawn the account.");
        assertEquals(beforeDeposit1, transaction1.getBalance(), 0);
        assertEquals(transaction1.getBalance(), bank.getBalance(daniel), 0);
    }

    @Test
    public void transactionTest2() throws Exception {
        Transaction t2 = new Transaction(bank, john, 1111);
        double beforeDeposit1 = t2.getBalance();
        double amount = 19239.34;
        t2.credit(amount);
        assertEquals(beforeDeposit1 + amount, t2.getBalance(), 0);
        assertTrue(t2.debit(amount), "Debit was unsuccessful.");
        assertEquals(beforeDeposit1, t2.getBalance(), 0);
        assertEquals(t2.getBalance(), bank.getBalance(john), 0);
    }
}
