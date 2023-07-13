/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.services;

import com.mycompany.eurofootball.dto.UserRegistrationDto;
import com.mycompany.eurofootball.validators.PasswordValidator;
import com.mycompany.eurofootball.validators.UsernameValidator;

/**
 *
 * @author calmin
 */
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private UsernameValidator _usernameValidator;
    private PasswordValidator _passwordValidator;

    public UserRegistrationServiceImpl(UsernameValidator usernameValidator, PasswordValidator passwordValidator) {
        this._usernameValidator = usernameValidator;
        this._passwordValidator = passwordValidator;
    }

    ;
    
    @Override
    public boolean registerUser(UserRegistrationDto userRegistration) {
        
        if(!_usernameValidator.validateUsername(userRegistration.getUsername())){
            System.out.println("Username not validated");
            return false;
        }
        
        if(!_passwordValidator.validatePassword(userRegistration.getPassword())){
            System.out.println("Password not validated");
            return false;
        }
        
        //TO DO - save details
        return true;       
    }

}
