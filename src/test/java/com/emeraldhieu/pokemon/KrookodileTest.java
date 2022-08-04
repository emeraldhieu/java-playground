package com.emeraldhieu.pokemon;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KrookodileTest {

    @Test
    public void memberIsBlastoise() {
        // GIVEN
        Krookodile krookodile = new Krookodile(List.of(
            new Blastoise()
        ));

        // WHEN
        int damage = krookodile.getDamage();

        // THEN
        assertEquals(258, damage);
    }

    @Test
    public void memberIsKrookodileWhoHasMemberBlastoise() {
        // GIVEN
        Krookodile krookodile = new Krookodile(List.of(
            new Krookodile(List.of(
                new Blastoise()
            ))
        ));

        // WHEN
        int damage = krookodile.getDamage();

        // THEN
        assertEquals(258, damage);
    }
}