/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.services;

import com.mycompany.eurofootball.dto.UserLoginDto;
import com.mycompany.eurofootball.models.User;
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

    private UserLookup userLookup;
    
    public UserLoginServiceImpl(UserLookup userLookup){
        this.userLookup = userLookup;
    }
    
    @Override
    public User loginUser(UserLoginDto userLogin) throws Exception{
        User retrievedUser =  userLookup.getUser(userLogin);
        if(retrievedUser == null){
            throw new Exception("User not found.");
        }
        retrievedUser.setPassword("");
        return retrievedUser;
    }
    
    
}

