/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.validators;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 *
 * @author calmin
 */
public class UsernameValidatorImpl implements UsernameValidator {

    //A valid username should be at least five (5) characters long, contain no spaces, contain at least one capital letter and at least one special character.

    @Override
    public boolean validateUsername(String username) {
        if(username == null)
            return false;

        if (username.length() < 5) {
            return false;
        }

        if (!hasCapitalLetter(username)){
            return false;
        }

        if (!hasSpecialCharacter(username)){
            return false;
        }

        if(hasSpace(username)){
            return false;
        }
        
        if(!hasNumber(username)){
            return false;
        }
        
        return true;
        
        
    }

    private boolean hasCapitalLetter(String username) {
        for (char c : username.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
    // private boolean hasCapitalLetterAsWell(String username){
    //     String lowercase = username.toLowerCase();
    //     return lowercase.compareTo(username) != 0;
    // }

    private boolean hasSpecialCharacter(String username) {
        for (char c : username.toCharArray()) {
            if (!Character.isWhitespace(c) && !Character.isDigit(c) && !Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }


    private boolean hasSpace(String username) {
        for (char c : username.toCharArray()) {
            if (Character.isWhitespace(c)) {
                return true;
            }
        }
        return false;
    }
    
    
    private boolean hasNumber(String username){
        
        for(char c: username.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        
        return false;
    }
}
