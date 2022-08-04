package com.emeraldhieu.pokemon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FightTest {

    private final Random random = mock(Random.class);

    private final List<Pokemon> pokemons = List.of(
        new Blastoise(),
        new Mew(random)
    );

    private final Fight fight = new Fight(pokemons);

    @BeforeEach
    public void init() {

    }

    @Test
    public void blastoise() {
        // GIVEN
        Pokemon pokemon = new Blastoise();

        // WHEN
        int damage = fight.hit(pokemon.getAttackerType());

        // THEN
        assertEquals(258, damage);
    }

    @Test
    public void mewWithCriticalHit() {
        // GIVEN
        Pokemon pokemon = new Mew(mock(Random.class)); // This random doesn't matter
        when(random.nextInt(10)).thenReturn(0);

        // WHEN
        int damage = fight.hit(pokemon.getAttackerType());

        // THEN
        assertEquals(300, damage);
    }

    @Test
    public void mewWithoutCriticalHit() {
        // GIVEN
        Pokemon pokemon = new Mew(mock(Random.class)); // This random doesn't matter
        when(random.nextInt(10)).thenReturn(1);

        // WHEN
        int damage = fight.hit(pokemon.getAttackerType());

        // THEN
        assertEquals(150, damage);
    }

    @Test
    public void nonexistentPokemonThrowsException() {
        // WHEN and THEN
        assertThrows(IllegalArgumentException.class, () -> {
            fight.hit(42);
        });
    }
}