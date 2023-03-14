package com.emeraldhieu.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringReversalTest {

    StringReversal stringReversal = new StringReversal();

    @Test
    public void hello() {
        // GIVEN
        String str = "Hello";

        // WHEN
        String reversedStr = stringReversal.reverseString(str);

        // THEN
        assertEquals("olleH", reversedStr);
    }

    @Test
    public void programmingIsFun() {
        // GIVEN
        String str = "Programming is fun";

        // WHEN
        String reversedStr = stringReversal.reverseString(str);

        // THEN
        assertEquals("nuf si gnimmargorP", reversedStr);
    }

    @Test
    public void helloWithDifferentStoppingCondition() {
        // GIVEN
        String str = "Hello";

        // WHEN
        String reversedStr = stringReversal.reverseStringWithDifferentStoppingCondition(str);

        // THEN
        assertEquals("olleH", reversedStr);
    }

    @Test
    public void programmingIsFunWithDifferentStoppingCondition() {
        // GIVEN
        String str = "Programming is fun";

        // WHEN
        String reversedStr = stringReversal.reverseStringWithDifferentStoppingCondition(str);

        // THEN
        assertEquals("nuf si gnimmargorP", reversedStr);
    }
}