/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.validators;

import java.util.regex.Pattern;

/**
 *
 * @author calmin
 */
public class RegExPasswordValidatorImpl implements PasswordValidator {

    @Override
    public boolean validatePassword(String password) {
       if(password == null){
           return false;
       }

       String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
       return Pattern.matches(regex, password);
    }

}
