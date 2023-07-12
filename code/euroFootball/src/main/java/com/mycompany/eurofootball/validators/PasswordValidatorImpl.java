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
        
        if(password == null)
            return false;

        if (!hasNumber(password)){
            return false;
        }

        if (!hasCapitalLetter(password)){
            return false;
        }
        
        if (password.length() < 8){
            return false;
        }
        
        if(hasSpace(password)){
            return false;
        }
        
        if(!hasSpecialCharacter(password)){
            return false;
        }
        
        return true;
    }
    
    
    private boolean hasNumber(String password){
        //    char[] chars = password.toCharArray();
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
        
        private boolean hasSpace(String password) {
            for (char c : password.toCharArray()) {
                if (Character.isWhitespace(c)) {
                   return true;
                }
            }
            return false;
        }
        
        private boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isWhitespace(c) && !Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }
}