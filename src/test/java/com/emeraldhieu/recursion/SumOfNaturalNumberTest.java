package com.emeraldhieu.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfNaturalNumberTest {

    private SumOfNaturalNumber sumOfNaturalNumber = new SumOfNaturalNumber();

    @Test
    public void ten() {
        // GIVEN
        int number = 10;

        // WHEN
        int result = sumOfNaturalNumber.sum(number);

        // THEN
        assertEquals(55, result);
    }

    @Test
    public void ninetyNine() {
        // GIVEN
        int number = 99;

        // WHEN
        int result = sumOfNaturalNumber.sum(number);

        // THEN
        assertEquals(4950, result);
    }
}