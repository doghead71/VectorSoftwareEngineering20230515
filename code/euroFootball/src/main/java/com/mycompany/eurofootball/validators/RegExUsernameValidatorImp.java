/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.validators;

import java.util.regex.Pattern;

/**
 *
 * @author Kraine
 * 
 * validates username using regular expression
 */
public class RegExUsernameValidatorImp implements UsernameValidator{

    @Override
    public boolean validateUsername(String username) {
        if(username == null){
           return false;
       }

       String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{5,}$"; //1 capital letter, 1 number, 1 special character and 5 characters minimum
       
       return Pattern.matches(regex, username); //checks if provided username matches the regex pattern then returns true or false
    }
    
}
