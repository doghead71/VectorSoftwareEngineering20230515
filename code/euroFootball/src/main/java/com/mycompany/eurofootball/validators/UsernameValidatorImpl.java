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
    
    private boolean hasCapitalLetterAsWell(String username){
        String lowercase = username.toLowerCase();
        return lowercase.compareTo(username) != 0;
    }

}
