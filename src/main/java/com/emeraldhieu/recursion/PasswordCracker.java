package com.emeraldhieu.recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PasswordCracker {

    public String crack(List<String> passwords, String loginAttempt) {
        // Fail-fast if loginAttempt doesn't contain any existing password.
        if (!passwords.stream()
            .anyMatch(password -> loginAttempt.contains(password))) {
            return "WRONG PASSWORD";
        }

        // Filter out passwords that don't exist in loginAttempt.
        List<String> passwordsExistedInLoginAttempt = passwords.stream()
            .filter(password -> loginAttempt.contains(password))
            .collect(Collectors.toList());

        List<Integer> loginAttemptChars = loginAttempt.chars()
            .mapToObj(value -> value)
            .collect(Collectors.toList());

        Set<Integer> uniqueChars = passwords.stream()
            .map(password -> password.chars()
                .mapToObj(value -> value)
                .collect(Collectors.toList()))
            .flatMap(Collection::stream)
            .collect(Collectors.toSet());

        List<Integer> charDifference = new ArrayList<>(loginAttemptChars);
        charDifference.removeAll(uniqueChars);
        if (!charDifference.isEmpty()) {
            return "WRONG PASSWORD";
        }

        List<String> passwordFootprints = new LinkedList<>();
        return crack(passwordsExistedInLoginAttempt, loginAttempt, passwordFootprints);
    }

    private String crack(List<String> passwords, String loginAttempt, List<String> passwordFootprints) {
        String builtPassword = getBuiltPassword(passwordFootprints);

        // Succeed. Go back to the previous frame.
        if (builtPassword.equals(loginAttempt)) {
            return getReturnValue(passwordFootprints);
        }

        // Fail. Go back to the previous frame.
        if (builtPassword.length() == loginAttempt.length()) {
            return "";
        }

        /*
         * Fail-fast if the loginAttempt doesn't contain the built password.
         * Go back to the previous frame.
         */
        if (!loginAttempt.contains(builtPassword)) {
            return "";
        }

        for (int i = 0; i < passwords.size(); ++i) {
            String passwordToConcatenate = passwords.get(i);
            passwordFootprints.add(passwordToConcatenate);
            System.out.println(passwordFootprints);

            String crackedPassword = crack(passwords, loginAttempt, passwordFootprints);
            String builtPasswordAgain = crackedPassword.replace(" ", "");
            if (builtPasswordAgain.equals(loginAttempt)) {
                return crackedPassword; // No need to do anything more.
            }
            // Remove the last password, give another chance to the next password
            passwordFootprints.remove(passwordFootprints.size() - 1);
        }
        return "WRONG PASSWORD";
    }

    private String getBuiltPassword(List<String> passwordFootprints) {
        return passwordFootprints.stream().collect(Collectors.joining());
    }

    private String getReturnValue(List<String> passwords) {
        return passwords.stream().collect(Collectors.joining(" "));
    }
}
