package com.emeraldhieu.cardtypecache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DefaultCardTypeCacheTest {

    private CardTypeCache cardTypeCache;

    @BeforeEach
    public void setUp() {
        List<BinRange> binRanges = Arrays.asList(
            new BinRange("400000000000", "419999999999", "visa"),
            new BinRange("420008000000", "420008999999", "visadebit"),
            new BinRange("435000000000", "435000999999", "something"),
            new BinRange("540000000000", "599999999999", "mc")
        );

        cardTypeCache = new DefaultCardTypeCache(binRanges);
    }

    @Test
    public void test300000000000() {
        // GIVEN
        String cardNumber = "300000000000";

        // WHEN
        String result = cardTypeCache.get(cardNumber);

        // THEN
        assertNull(result);
    }

    @Test
    public void test400000000000() {
        // GIVEN
        String cardNumber = "400000000000";

        // WHEN
        String result = cardTypeCache.get(cardNumber);

        // THEN
        assertEquals("visa", result);
    }

    @Test
    public void test400000000001() {
        // GIVEN
        String cardNumber = "400000000001";

        // WHEN
        String result = cardTypeCache.get(cardNumber);

        // THEN
        assertEquals("visa", result);
    }

    @Test
    public void test419999999999() {
        // GIVEN
        String cardNumber = "419999999999";

        // WHEN
        String result = cardTypeCache.get(cardNumber);

        // THEN
        assertEquals("visa", result);
    }

    @Test
    public void test540000000000() {
        // GIVEN
        String cardNumber = "540000000000";

        // WHEN
        String result = cardTypeCache.get(cardNumber);

        // THEN
        assertEquals("mc", result);
    }

    @Test
    public void test599999999999() {
        // GIVEN
        String cardNumber = "599999999999";

        // WHEN
        String result = cardTypeCache.get(cardNumber);

        // THEN
        assertEquals("mc", result);
    }

    @Test
    public void test699999999999() {
        // GIVEN
        String cardNumber = "699999999999";

        // WHEN
        String result = cardTypeCache.get(cardNumber);

        // THEN
        assertNull(result);
    }
}