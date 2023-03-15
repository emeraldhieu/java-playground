package com.emeraldhieu.pokemon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MewTest {

    private ThreadLocalRandom random;
    private Mew mew;

    @BeforeEach
    public void init() {
        random = mock(ThreadLocalRandom.class);
        mew = new Mew(random);
    }

    @Test
    public void getDamageWhenRandomResultsInZero() {
        // GIVEN
        when(random.nextInt(10)).thenReturn(0);

        // WHEN
        int damage = mew.getDamage();

        // THEN
        assertEquals(300, damage);
    }

    @Test
    public void getDamageWhenRandomResultsInOne() {
        // GIVEN
        when(random.nextInt(10)).thenReturn(1);

        // WHEN
        int damage = mew.getDamage();

        // THEN
        assertEquals(150, damage);
    }
}