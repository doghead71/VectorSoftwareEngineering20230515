/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.eurofootball.services;

import com.mycompany.eurofootball.dto.UserRegistrationDto;
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
 * @author calmin
 */
public class UserRegistrationServiceImplTest {

    @Mock
    private UsernameValidator usernameValidator;
    @Mock
    private PasswordValidator passwordValidator;

    private UserRegistrationDto userRegistration = new UserRegistrationDto();

    public UserRegistrationServiceImplTest() {
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
     * Test of registerUser method, of class UserRegistrationServiceImpl.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");

        Mockito.when(usernameValidator.validateUsername(Mockito.any())).thenReturn(Boolean.TRUE);
        Mockito.when(passwordValidator.validatePassword(Mockito.any())).thenReturn(Boolean.TRUE);

        UserRegistrationServiceImpl instance = new UserRegistrationServiceImpl(usernameValidator, passwordValidator);
        boolean expResult = true;
        boolean result = instance.registerUser(userRegistration);
        assertEquals(expResult, result); //test fails when expResult is not equal to result
    }

    @Test
    public void testRegisterUserInvalidUserName() {
        System.out.println("registerUserInvalidUsername");

        Mockito.when(usernameValidator.validateUsername(Mockito.any())).thenReturn(Boolean.FALSE);
        Mockito.when(passwordValidator.validatePassword(Mockito.any())).thenReturn(Boolean.TRUE);

        UserRegistrationServiceImpl instance = new UserRegistrationServiceImpl(usernameValidator, passwordValidator);
        boolean expResult = false;
        boolean result = instance.registerUser(userRegistration);
        assertEquals(expResult, result);
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        System.out.println("registerUserInvalidPassword");

        Mockito.when(usernameValidator.validateUsername(Mockito.any())).thenReturn(Boolean.TRUE);
        Mockito.when(passwordValidator.validatePassword(Mockito.any())).thenReturn(Boolean.FALSE);

        UserRegistrationServiceImpl instance = new UserRegistrationServiceImpl(usernameValidator, passwordValidator);
        boolean expResult = false;
        boolean result = instance.registerUser(userRegistration);
        assertEquals(expResult, result);
    }

    @Test
    public void testRegisterUserInvalidPasswordAndUsername() {
        System.out.println("registerUserInvalidPasswordAndUsername");

        Mockito.when(usernameValidator.validateUsername(Mockito.any())).thenReturn(Boolean.FALSE);
        Mockito.when(passwordValidator.validatePassword(Mockito.any())).thenReturn(Boolean.FALSE);

        UserRegistrationServiceImpl instance = new UserRegistrationServiceImpl(usernameValidator, passwordValidator);
        boolean expResult = false;
        boolean result = instance.registerUser(userRegistration);
        assertEquals(expResult, result);
    }
}
