package com.emeraldhieu.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerSumTest {

    private PowerSum powerSum = new PowerSum();

    @Test
    public void tenAndTwo() {
        // WHEN
        int count = powerSum.getCombinationCount(10, 2);

        // THEN
        assertEquals(1, count);
    }

    @Test
    public void oneHundredAndTwo() {
        // WHEN
        int count = powerSum.getCombinationCount(100, 2);

        // THEN
        assertEquals(3, count);
    }

    @Test
    public void oneHundredAndThree() {
        // WHEN
        int count = powerSum.getCombinationCount(100, 3);

        // THEN
        assertEquals(1, count);
    }

    /**
     * TODO Solve this.
     */
    //@Test
    public void fourHundredAndTwo() {
        // WHEN
        int count = powerSum.getCombinationCount(400, 2);

        // THEN
        assertEquals(55, count);
    }

    /**
     * TODO Solve this.
     */
    //@Test
    public void eightHundredAndTwo() {
        // WHEN
        int count = powerSum.getCombinationCount(800, 2);

        // THEN
        assertEquals(561, count);
    }
}