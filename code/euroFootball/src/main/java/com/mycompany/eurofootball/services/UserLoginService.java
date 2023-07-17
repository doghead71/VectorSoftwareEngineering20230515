/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.eurofootball.services;

import com.mycompany.eurofootball.dto.UserLoginDto;

/**
 *
 * @author Kraine
 */
public interface UserLoginService {
    boolean loginUser(UserLoginDto userLogin);
    
}
