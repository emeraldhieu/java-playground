package com.emeraldhieu.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RomanToDecimalConverterTest {

    private final RomanToDecimalConverter converter = new RomanToDecimalConverter();

    @Test
    public void one() {
        // GIVEN
        String romanNumber = "I";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(1, decimalNumber);
    }

    @Test
    public void five() {
        // GIVEN
        String romanNumber = "V";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(5, decimalNumber);
    }

    @Test
    public void ten() {
        // GIVEN
        String romanNumber = "V";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(5, decimalNumber);
    }

    @Test
    public void fifty() {
        // GIVEN
        String romanNumber = "L";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(50, decimalNumber);
    }

    @Test
    public void oneHundred() {
        // GIVEN
        String romanNumber = "C";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(100, decimalNumber);
    }

    @Test
    public void fiveHundred() {
        // GIVEN
        String romanNumber = "D";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(500, decimalNumber);
    }

    @Test
    public void oneThousand() {
        // GIVEN
        String romanNumber = "M";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(1000, decimalNumber);
    }

    @Test
    public void six() {
        // GIVEN
        String romanNumber = "VI";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(6, decimalNumber);
    }

    @Test
    public void seventy() {
        // GIVEN
        String romanNumber = "LXX";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(70, decimalNumber);
    }

    @Test
    public void oneThousandAndTwoHundred() {
        // GIVEN
        String romanNumber = "MCC";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(1200, decimalNumber);
    }

    @Test
    public void four() {
        // GIVEN
        String romanNumber = "IV";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(4, decimalNumber);
    }

    @Test
    public void ninetyNine() {
        // GIVEN
        String romanNumber = "XCIX";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(99, decimalNumber);
    }

    @Test
    public void oneThousandNineHundredFortyFour() {
        // GIVEN
        String romanNumber = "XCIX";

        // WHEN
        int decimalNumber = converter.convert(romanNumber);

        // THEN
        Assertions.assertEquals(99, decimalNumber);
    }
}