package com.emeraldhieu.pokemon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Krookodile implements Pokemon {

    private final List<Pokemon> pokemons;

    @Override
    public int getAttackerType() {
        return 0;
    }

    @Override
    public int getDamage() {
        return pokemons.stream()
            .mapToInt(Pokemon::getDamage)
            .sum();
    }
}
