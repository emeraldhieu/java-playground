package com.emeraldhieu.hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheTimeInWordsTest {

    private TheTimeInWords timeInWords = new TheTimeInWords();

    @Test
    public void oneOclock() {
        // GIVEN
        int hour = 1;
        int minute = 0;

        // WHEN
        String word = timeInWords.timeInWords(hour, minute);

        // THEN
        assertEquals("One o'clock", word);
    }

    @Test
    public void elevenOclock() {
        // GIVEN
        int hour = 11;
        int minute = 0;

        // WHEN
        String word = timeInWords.timeInWords(hour, minute);

        // THEN
        assertEquals("Eleven o'clock", word);
    }

    @Test
    public void oneMinutePastFive() {
        // GIVEN
        int hour = 5;
        int minute = 1;

        // WHEN
        String word = timeInWords.timeInWords(hour, minute);

        // THEN
        assertEquals("One minute past five", word);
    }

    @Test
    public void tenMinutesPastFive() {
        // GIVEN
        int hour = 5;
        int minute = 10;

        // WHEN
        String word = timeInWords.timeInWords(hour, minute);

        // THEN
        assertEquals("Ten minutes past five", word);
    }

    @Test
    public void quarterPastFive() {
        // GIVEN
        int hour = 5;
        int minute = 15;

        // WHEN
        String word = timeInWords.timeInWords(hour, minute);

        // THEN
        assertEquals("Quarter past five", word);
    }

    @Test
    public void halfPastFive() {
        // GIVEN
        int hour = 5;
        int minute = 30;

        // WHEN
        String word = timeInWords.timeInWords(hour, minute);

        // THEN
        assertEquals("Half past five", word);
    }

    @Test
    public void twentyMinutesToSix() {
        // GIVEN
        int hour = 5;
        int minute = 40;

        // WHEN
        String word = timeInWords.timeInWords(hour, minute);

        // THEN
        assertEquals("Twenty minutes to six", word);
    }

    @Test
    public void quarterToSix() {
        // GIVEN
        int hour = 5;
        int minute = 45;

        // WHEN
        String word = timeInWords.timeInWords(hour, minute);

        // THEN
        assertEquals("Quarter to six", word);
    }

    @Test
    public void thirteenMinutesToSix() {
        // GIVEN
        int hour = 5;
        int minute = 47;

        // WHEN
        String word = timeInWords.timeInWords(hour, minute);

        // THEN
        assertEquals("Thirteen minutes to six", word);
    }

    @Test
    public void twentyEightMinutesToSix() {
        // GIVEN
        int hour = 5;
        int minute = 28;

        // WHEN
        String word = timeInWords.timeInWords(hour, minute);

        // THEN
        assertEquals("Twenty eight minutes past five", word);
    }
}