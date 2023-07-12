/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.validators;

/**
 *
 * @author Bryan Scarlet
 */
public class PasswordValidatorImpl implements PasswordValidator {
    @Override
    public boolean validatePassword(String password){
        
        if (!hasNumber(password)){
            return false;
        }
        
        if (!hasCapitalLetter(password)){
            return false;
        }
        
        return true;
    }
        private boolean hasNumber(String password){
           char[] chars = password.toCharArray();
           for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;

    }
        
        private boolean hasCapitalLetter(String password){
            for (char c:password.toCharArray()){
                if (Character.isUpperCase(c)) {
                 return true;
                }
            }
            return false;
        }
}