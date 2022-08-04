package com.emeraldhieu.pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlastoiseTest {

    private final Blastoise blastoise = new Blastoise();

    @Test
    public void getDamage() {
        assertEquals(258, blastoise.getDamage());
    }
}