/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.eurofootball.services;

import com.mycompany.eurofootball.dto.UserLoginDto;
import com.mycompany.eurofootball.validators.PasswordValidator;
import com.mycompany.eurofootball.validators.UsernameValidator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Kraine
 */


public class UserLoginServiceImplTest {
    
    @Mock
    private UsernameValidator usernameValidator;
    @Mock
    private PasswordValidator passwordValidator;
    
    private UserLoginDto userLogin = new UserLoginDto();
 
    public UserLoginServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loginUser method, of class UserLoginServiceImpl.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        
//        using Mokito to mock username and password
        Mockito.when(usernameValidator.validateUsername(Mockito.any())).thenReturn(Boolean.TRUE);
        Mockito.when(passwordValidator.validatePassword(Mockito.any())).thenReturn(Boolean.TRUE);
        
        UserLoginServiceImpl instance = new UserLoginServiceImpl(usernameValidator, passwordValidator);
        boolean expResult = true;
        boolean result = instance.loginUser(userLogin);
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testLoginUserInvalidUsername() {
        System.out.println("loginUserInvalidUsername");
        
//        using Mokito to mock username and password
        Mockito.when(usernameValidator.validateUsername(Mockito.any())).thenReturn(Boolean.FALSE);
        Mockito.when(passwordValidator.validatePassword(Mockito.any())).thenReturn(Boolean.TRUE);
        
        UserLoginServiceImpl instance = new UserLoginServiceImpl(usernameValidator, passwordValidator);
        boolean expResult = false;
        boolean result = instance.loginUser(userLogin);
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testLoginUserInvalidPassword() {
        System.out.println("loginUserInvalidPassword");
        
//        using Mokito to mock username and password
        Mockito.when(usernameValidator.validateUsername(Mockito.any())).thenReturn(Boolean.TRUE);
        Mockito.when(passwordValidator.validatePassword(Mockito.any())).thenReturn(Boolean.FALSE);
        
        UserLoginServiceImpl instance = new UserLoginServiceImpl(usernameValidator, passwordValidator);
        boolean expResult = false;
        boolean result = instance.loginUser(userLogin);
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testLoginUserInvalidUsernameAndPassword() {
        System.out.println("loginUserInvalidUsernameAndPassword");
        
//        using Mokito to mock username and password
        Mockito.when(usernameValidator.validateUsername(Mockito.any())).thenReturn(Boolean.FALSE);
        Mockito.when(passwordValidator.validatePassword(Mockito.any())).thenReturn(Boolean.FALSE);
        
        UserLoginServiceImpl instance = new UserLoginServiceImpl(usernameValidator, passwordValidator);
        boolean expResult = false;
        boolean result = instance.loginUser(userLogin);
        assertEquals(expResult, result);
    }
}
