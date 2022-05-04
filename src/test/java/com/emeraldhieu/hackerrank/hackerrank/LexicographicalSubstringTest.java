package com.emeraldhieu.hackerrank.hackerrank;

import com.emeraldhieu.hackerrank.LexicographicalSubstring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexicographicalSubstringTest {

    private LexicographicalSubstring lexicographicalSubstring = new LexicographicalSubstring();

    @Test
    public void string1() {
        // GIVEN
        String s = "welcometojava";
        int k = 3;

        // WHEN
        String result = lexicographicalSubstring.getSmallestAndLargest(s, k);

        // THEN
        assertEquals("ava\nwel", result);
    }

    @Test
    public void string2() {
        // GIVEN
        /**
         * hel
         * ell
         * llo
         * low
         * owo
         * wor
         * orl
         * rld
         */
        String s = "helloworld";
        int k = 3;

        // WHEN
        String result = lexicographicalSubstring.getSmallestAndLargest(s, k);

        // THEN
        assertEquals("ell\nwor", result);
    }


    @Test
    public void string1WithK4() {
        // GIVEN
        /**
         * welc
         * elco
         * lcom
         * come
         * omet
         * meto
         * etoj
         * toja
         * ojav
         * java
         */
        String s = "welcometojava";
        int k = 4;

        // WHEN
        String result = lexicographicalSubstring.getSmallestAndLargest(s, k);

        // THEN
        assertEquals("come\nwelc", result);
    }
}