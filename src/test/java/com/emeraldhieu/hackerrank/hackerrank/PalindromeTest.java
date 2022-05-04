package com.emeraldhieu.hackerrank.hackerrank;

import com.emeraldhieu.hackerrank.Palindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

    private final Palindrome palindrome = new Palindrome();

    @Test
    public void test1() {
        // GIVEN
        String s = "madam";

        // WHEN
        boolean result = palindrome.check(s);

        // THEN
        assertTrue(result);
    }

    @Test
    public void test2() {
        // GIVEN
        String s = "racecar";

        // WHEN
        boolean result = palindrome.check(s);

        // THEN
        assertTrue(result);
    }

    @Test
    public void test3() {
        // GIVEN
        String s = "redivider";

        // WHEN
        boolean result = palindrome.check(s);

        // THEN
        assertTrue(result);
    }
}