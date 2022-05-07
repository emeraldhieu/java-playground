package com.emeraldhieu.hackerrank;

import com.emeraldhieu.hackerrank.Anagram;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramTest {

    @Test
    public void twoCharacters() {
        // GIVEN
        Anagram anagram = new Anagram("ab");
        String stringToCheck = "ba";

        // WHEN
        boolean isAnagram = anagram.isAnagram(stringToCheck);

        // THEN
        assertTrue(isAnagram);
    }

    @Test
    public void threeCharacters() {
        // GIVEN
        Anagram anagram = new Anagram("abc");
        String stringToCheck = "cba";

        // WHEN
        boolean isAnagram = anagram.isAnagram(stringToCheck);

        // THEN
        assertTrue(isAnagram);
    }

    @Test
    public void twoCharactersWithAWhitespace() {
        // GIVEN
        Anagram anagram = new Anagram("a c");
        String stringToCheck = "c a";

        // WHEN
        boolean isAnagram = anagram.isAnagram(stringToCheck);

        // THEN
        assertTrue(isAnagram);
    }

    @Test
    public void fullString() {
        // GIVEN
        Anagram anagram = new Anagram("parliament");
        String stringToCheck = "partialmen";

        // WHEN
        boolean isAnagram = anagram.isAnagram(stringToCheck);

        // THEN
        assertTrue(isAnagram);
    }

    @Test
    public void fullString2() {
        // GIVEN
        Anagram anagram = new Anagram("software");
        String stringToCheck = "swearoft";

        // WHEN
        boolean isAnagram = anagram.isAnagram(stringToCheck);

        // THEN
        assertTrue(isAnagram);
    }

    @Test
    public void fullString2WithPunctuation() {
        // GIVEN
        Anagram anagram = new Anagram("software");
        String stringToCheck = "swearoft";

        // WHEN
        boolean isAnagram = anagram.isAnagram(stringToCheck);

        // THEN
        assertTrue(isAnagram);
    }

    /*
    @Test
    public void isPunctuation() {
        Anagram anagram = new Anagram("whatever");
        boolean result = anagram.isPunctuation(',');
        assertTrue(result);
    }
     */

    @Test
    public void fullString3() {
        // GIVEN
        Anagram anagram = new Anagram("anagramm");
        String stringToCheck = "marganaa";

        // WHEN
        boolean isAnagram = anagram.isAnagram(stringToCheck);

        // THEN
        assertFalse(isAnagram);
    }
}