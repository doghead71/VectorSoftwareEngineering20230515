/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.services;

import com.mycompany.eurofootball.dto.UserLoginDto;
import com.mycompany.eurofootball.validators.PasswordValidator;
import com.mycompany.eurofootball.validators.UsernameValidator;

/**
 *
 * @author Kraine
 * 
 * 
 * Grants access to user with valid username and password
 */

public class UserLoginServiceImpl implements UserLoginService{
    
    private UsernameValidator _usernameValidator;
    private PasswordValidator _passwordValidator;

    public UserLoginServiceImpl(UsernameValidator usernameValidator, PasswordValidator passwordValidator){
//        constructor accepts interfaces as arguments to allow different implementations
        this._passwordValidator = passwordValidator;
        this._usernameValidator = usernameValidator;
    }
    
    @Override
    public boolean loginUser(UserLoginDto userLogin) {
//        validate username
        if(!_usernameValidator.validateUsername(userLogin.getUsername())){
            System.out.println("Invalid username.");
            return false;
        }
//        validate password
        if(!_passwordValidator.validatePassword(userLogin.getPassword())){
            System.out.println("Invalid password.");
            return false;
        }
        //TO DO - grant access
        return true;
    }
    
}
