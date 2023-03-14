package com.emeraldhieu.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecimalToBinaryTest {

    private DecimalToBinary decimalToBinary = new DecimalToBinary();

    @Test
    public void thirteen() {
        // GIVEN
        int number = 13;

        // WHEN
        String binaryStr = decimalToBinary.convertToBinary(number);

        // THEN
        assertEquals("1101", binaryStr);
    }

    @Test
    public void fortyTwo() {
        // GIVEN
        int number = 42;

        // WHEN
        String binaryStr = decimalToBinary.convertToBinary(number);

        // THEN
        assertEquals("101010", binaryStr);
    }

    @Test
    public void ninetyNine() {
        // GIVEN
        int number = 99;

        // WHEN
        String binaryStr = decimalToBinary.convertToBinary(number);

        // THEN
        assertEquals("1100011", binaryStr);
    }
}