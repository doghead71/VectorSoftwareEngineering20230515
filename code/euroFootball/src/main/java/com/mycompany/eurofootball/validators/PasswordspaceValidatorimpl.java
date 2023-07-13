package com.mycompany.eurofootball.validators;

public class PasswordspaceValidatorImpl implements PasswordspaceValidator {
    @Override
    public boolean validatePassword(String password) {
        boolean hasSpaces = PasswordSpaceChecker.hasSpaces(password);
        if (hasSpaces) {
            System.out.println("Password contains spaces");
            return false;
        } else {
            return true;
        }
    }
}
