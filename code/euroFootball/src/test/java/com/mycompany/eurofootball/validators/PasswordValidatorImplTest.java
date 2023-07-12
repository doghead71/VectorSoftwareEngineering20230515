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

    private PasswordValidator validator;

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
        validator = new PasswordValidatorImpl();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testValidPassword() {
        String Password = "Password@123";
        boolean output = validator.validatePassword(Password);
        assertTrue(output);
    }

    @org.junit.Test
    public void testInvalidLength() {
        String Password = "Pass@123";
        boolean output = validator.validatePassword(Password);
        assertFalse(output);
    }

    @org.junit.Test
    public void testInvalidHasSpace() {
        String Password = "Pass word@123";
        boolean output = validator.validatePassword(Password);
        assertFalse(output);
    }

    @org.junit.Test
    public void testInvalidNoNumbers() {
        String Password = "Password@";
        boolean output = validator.validatePassword(Password);
        assertFalse(output);
    }

    @org.junit.Test
    public void testInvalidNoSpecialCharacters() {
        String Password = "Password123";
        boolean output = validator.validatePassword(Password);
        assertFalse(output);
    }

    @org.junit.Test
    public void testNullString() {
        String Password = null;
        boolean output = validator.validatePassword(Password);
        assertFalse(output);
    }

}
