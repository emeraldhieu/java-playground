package com.emeraldhieu.hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {

    private LongestSubstring longestSubstring = new LongestSubstring();

    @Test
    void case1() {
        // GIVEN
        String s = "abcabcbb";

        // WHEN
        int length = longestSubstring.lengthOfLongestSubstring(s);

        // THEN
        assertEquals(3, length);
    }

    @Test
    void case2() {
        // GIVEN
        String s = "bbbbb";

        // WHEN
        int length = longestSubstring.lengthOfLongestSubstring(s);

        // THEN
        assertEquals(1, length);
    }

    @Test
    void case3() {
        // GIVEN
        String s = "pwwkew";

        // WHEN
        int length = longestSubstring.lengthOfLongestSubstring(s);

        // THEN
        assertEquals(3, length);
    }

    @Test
    void case4() {
        // GIVEN
        String s = " ";

        // WHEN
        int length = longestSubstring.lengthOfLongestSubstring(s);

        // THEN
        assertEquals(1, length);
    }

    @Test
    void case5() {
        // GIVEN
        String s = "dvdf";

        // WHEN
        int length = longestSubstring.lengthOfLongestSubstring(s);

        // THEN
        assertEquals(3, length);
    }
}