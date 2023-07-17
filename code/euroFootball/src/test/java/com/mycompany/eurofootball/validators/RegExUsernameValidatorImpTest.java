/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.validators;

/**
 *
 * @author Kraine
 */
public class RegExUsernameValidatorImpTest extends UsernameValidatorImplTest{
    
    @Override
    protected void getUsernameValidator(){
        validator = new RegExUsernameValidatorImp();
    }
}
