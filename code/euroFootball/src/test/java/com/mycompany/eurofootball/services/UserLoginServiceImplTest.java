/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.eurofootball.services;

import com.mycompany.eurofootball.dto.UserLoginDto;
import com.mycompany.eurofootball.models.User;
import com.mycompany.eurofootball.validators.PasswordValidator;
import com.mycompany.eurofootball.validators.UsernameValidator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Kraine
 */
public class UserLoginServiceImplTest {

    @Mock
    private UserLookup userLookup;

    private UserLoginDto userLogin = new UserLoginDto();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

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
    public void testLoginUser() throws Exception {
        System.out.println("login User");

//        using Mokito to mock username and password
        User user = new User("username", "password", "", "", "", true);
        user.setUniversalIdentifier(1L);
        Mockito.when(userLookup.getUser(Mockito.any())).thenReturn(user);

        UserLoginServiceImpl instance = new UserLoginServiceImpl(userLookup);
        User expResult = user;
        User result = instance.loginUser(userLogin);
        assertEquals(result, expResult);
    }

    @Test
    public void testLoginInvalidUser() throws Exception {
        System.out.println("login Invalid User");

//        using Mokito to mock username and password
        Mockito.when(userLookup.getUser(Mockito.any())).thenReturn(null);

        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("User not found.");
        UserLoginServiceImpl instance = new UserLoginServiceImpl(userLookup);
        //User expResult = user;
        User result = instance.loginUser(userLogin);
        assertNull(result);
    }

    @Test
    public void testReturnedPasswordIsEmpty() throws Exception {
        System.out.println("login User");

//        using Mokito to mock username and password
        User user = new User();
        user.setPassword("password");
        user.setUniversalIdentifier(1L);
        Mockito.when(userLookup.getUser(Mockito.any())).thenReturn(user);

        UserLoginServiceImpl instance = new UserLoginServiceImpl(userLookup);
        String expResult = "";
        User result = instance.loginUser(userLogin);
        assertEquals(result.getPassword(), expResult);
    }

}
