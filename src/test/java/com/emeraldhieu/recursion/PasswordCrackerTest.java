package com.emeraldhieu.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordCrackerTest {

    private PasswordCracker passwordCracker = new PasswordCracker();

    @Test
    public void abrakadabra() {
        // GIVEN
        List<String> passwords = List.of("abra", "ka", "dabra");
        String loginAttempt = "abrakadabra";
        List<String> passwordFootprints = new ArrayList<>();

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt, passwordFootprints);

        // THEN
        assertEquals("abra ka dabra", crackedPassword);
    }

    @Test
    public void kaabra() {
        // GIVEN
        List<String> passwords = List.of("abra", "ka", "dabra");
        String loginAttempt = "kaabra";
        PasswordCracker passwordCracker = new PasswordCracker();
        List<String> passwordFootprints = new ArrayList<>();

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt, passwordFootprints);

        // THEN
        assertEquals("ka abra", crackedPassword);
    }

    @Test
    public void aba() {
        // GIVEN
        List<String> passwords = List.of("ab", "ba");
        String loginAttempt = "aba";
        List<String> passwordFootprints = new ArrayList<>();

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt, passwordFootprints);

        // THEN
        assertEquals("WRONG PASSWORD", crackedPassword);
    }

    @Test
    public void wedowhatwemustbecausewecan() {
        // GIVEN
        List<String> passwords = List.of("because", "can", "do", "must", "we", "what");
        String loginAttempt = "wedowhatwemustbecausewecan";
        List<String> passwordFootprints = new ArrayList<>();

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt, passwordFootprints);

        // THEN
        assertEquals("we do what we must because we can", crackedPassword);
    }
}