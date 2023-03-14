package com.emeraldhieu.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

    Palindrome palindrome = new Palindrome();

    @Test
    public void kayak() {
        // GIVEN
        String str = "kayak";

        // WHEN
        boolean result = palindrome.isPalindrome(str);

        // THEN
        assertTrue(result);
    }

    @Test
    public void racecar() {
        // GIVEN
        String str = "racecar";

        // WHEN
        boolean result = palindrome.isPalindrome(str);

        // THEN
        assertTrue(result);
    }

    @Test
    public void santa() {
        // GIVEN
        String str = "santa";

        // WHEN
        boolean result = palindrome.isPalindrome(str);

        // THEN
        assertFalse(result);
    }

    @Test
    public void redder() {
        // GIVEN
        String str = "redder";

        // WHEN
        boolean result = palindrome.isPalindrome(str);

        // THEN
        assertTrue(result);
    }

    @Test
    public void orange() {
        // GIVEN
        String str = "orange";

        // WHEN
        boolean result = palindrome.isPalindrome(str);

        // THEN
        assertFalse(result);
    }
}