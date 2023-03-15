package com.emeraldhieu.pokemon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Getter
public class Mew implements Pokemon {

    private final ThreadLocalRandom random;

    @Override
    public int getAttackerType() {
        return 151;
    }

    @Override
    public int getDamage() {
        int damage = 150;
        int oneToTen = random.nextInt(10) + 1; // 1-10; each number has 10% chance happening
        if (oneToTen == 1) {
            return damage * 2;
        }
        return damage;
    }
}
