package com.emeraldhieu.recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordCrackerTest {

    private PasswordCracker passwordCracker = new PasswordCracker();

    @Test
    public void abrakadabra() {
        // GIVEN
        List<String> passwords = List.of("abra", "ka", "dabra");
        String loginAttempt = "abrakadabra";

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt);

        // THEN
        assertEquals("abra ka dabra", crackedPassword);
    }

    @Test
    public void kaabra() {
        // GIVEN
        List<String> passwords = List.of("abra", "ka", "dabra");
        String loginAttempt = "kaabra";

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt);

        // THEN
        assertEquals("ka abra", crackedPassword);
    }

    @Test
    public void aba() {
        // GIVEN
        List<String> passwords = List.of("ab", "ba");
        String loginAttempt = "aba";

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt);

        // THEN
        assertEquals("WRONG PASSWORD", crackedPassword);
    }

    @Test
    public void wedowhatwemustbecausewecan() {
        // GIVEN
        List<String> passwords = List.of("because", "can", "do", "must", "we", "what");
        String loginAttempt = "wedowhatwemustbecausewecan";

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt);

        // THEN
        assertEquals("we do what we must because we can", crackedPassword);
    }

    @Test
    public void nktrsgtwbuzsbptzahomgtgnaoma() {
        // GIVEN
        List<String> passwords = List.of("zsnpgbqh", "bktrpgdwbu", "qhuhzxfh", "mxrgmga", "omgtgnqomb", "dffttrwlfh");
        String loginAttempt = "nktrsgtwbuzsbptzahomgtgnaoma";

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt);

        // THEN
        assertEquals("WRONG PASSWORD", crackedPassword);
    }

    @Test
    public void xtbyhnmedbcmhyewjzsdgxtbyhn() {
        // GIVEN
        List<String> passwords = List.of("xkof", "medbc", "mhyewjzsdg", "vkuzym", "tbeqv", "xtbyhn");
        String loginAttempt = "xtbyhnmedbcmhyewjzsdgxtbyhn";

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt);

        // THEN
        assertEquals("xtbyhn medbc mhyewjzsdg xtbyhn", crackedPassword);
    }

    @Test
    public void sduhkkhbqlrxnmsduhsduhqyyx() {
        // GIVEN
        List<String> passwords = List.of("alutwfal", "kkhbqlrxnm", "qyyx", "lwdgpchwic", "rdtgzvw", "sduh");
        String loginAttempt = "sduhkkhbqlrxnmsduhsduhqyyx";

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt);

        // THEN
        assertEquals("sduh kkhbqlrxnm sduh sduh qyyx", crackedPassword);
    }

    @Test
    public void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaab() {
        // GIVEN
        List<String> passwords = List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        String loginAttempt = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        // WHEN
        String crackedPassword = passwordCracker.crack(passwords, loginAttempt);

        // THEN
        assertEquals("WRONG PASSWORD", crackedPassword);
    }
}