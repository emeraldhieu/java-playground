package com.emeraldhieu.recursion;

import java.util.List;
import java.util.stream.Collectors;

public class PasswordCracker {

    public String crack(List<String> passwords, String loginAttempt, List<String> passwordFootprints) {
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
            String crackedPassword = crack(passwords, loginAttempt, passwordFootprints);
            String builtPasswordAgain = getBuiltPassword(passwordFootprints);
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
