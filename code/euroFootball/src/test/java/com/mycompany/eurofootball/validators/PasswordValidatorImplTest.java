/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.eurofootball.validators;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author  ackmine
 */
public class PasswordValidatorImplTest {

    protected PasswordValidator validator;
    
    protected void getPasswordValidaator() {
        validator = new PasswordValidatorImpl();
    }


    public PasswordValidatorImplTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
        getPasswordValidaator();
    }

    

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testValidPassword() {
        String password = "Password@123";
        boolean output = validator.validatePassword(password);
        assertTrue(output);
    }

    @org.junit.Test
    public void testInvalidLength() {
        String password = "Pass@12";
        boolean output = validator.validatePassword(password);
        assertFalse(output);
    }

    @org.junit.Test
    public void testInvalidHasSpace() {
        String password = "Pass word@123";
        boolean output = validator.validatePassword(password);
        assertFalse(output);
    }

    @org.junit.Test
    public void testInvalidNoNumbers() {
        String password = "Password@";
        boolean output = validator.validatePassword(password);
        assertFalse(output);
    }

    @org.junit.Test
    public void testInvalidNoSpecialCharacters() {
        String password = "Password123";
        boolean output = validator.validatePassword(password);
        assertFalse(output);
    }

    @org.junit.Test
    public void testNullString() {
        String password = null;
        boolean output = validator.validatePassword(password);
        assertFalse(output);
    }

}
