package com.emeraldhieu.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    private final Fibonacci fibonacci = new Fibonacci();

    @Test
    public void ten() {
        // GIVEN
        int number = 10;

        // WHEN
        long nthFibonacci = fibonacci.findNthFibonacci(number);

        // THEN
        assertEquals(55, nthFibonacci);
    }

    @Test
    public void seven() {
        // GIVEN
        int number = 7;

        // WHEN
        long nthFibonacci = fibonacci.findNthFibonacci(number);

        // THEN
        assertEquals(13, nthFibonacci);
    }
}