/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.validators;

/**
 *
 * @author calmin
 */
public class RegExPasswordValidatorImplTest extends PasswordValidatorImplTest {

    @Override
    protected void getPasswordVallidaator() {
        validator = new RegExPasswordValidatorImpl();
    }
}
