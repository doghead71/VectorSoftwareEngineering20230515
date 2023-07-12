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
    private boolean hasNumber(String password){
           char[] chars = password.toCharArray();
           for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;

    }
}