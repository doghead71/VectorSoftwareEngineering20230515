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
 * @author calmin
 */
public class UsernameValidatorImplTest {

    private UsernameValidator validator;

    public UsernameValidatorImplTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
        validator = new UsernameValidatorImpl();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testValidUserName() {
        String username = "Vti7@5";
        boolean output = validator.validateUsername(username);
        assertTrue(output);
    }

    @org.junit.Test
    public void testInvalidLength() {
        String username = "Vti@";
        boolean output = validator.validateUsername(username);
        assertFalse(output);
    }

    @org.junit.Test
    public void testInvalidHasSpace() {
        String username = "Vt i7@";
        boolean output = validator.validateUsername(username);
        assertFalse(output);
    }

    @org.junit.Test
    public void testInvalidNoCapitalLetter() {
        String username = "vti7@";
        boolean output = validator.validateUsername(username);
        assertFalse(output);
    }

    @org.junit.Test
    public void testInvalidNoNumbers() {
        String username = "Vti@rr";
        boolean output = validator.validateUsername(username);
        assertFalse(output);
    }

    @org.junit.Test
    public void testInvalidNoSpecialCharacters() {
        String username = "Vti75";
        boolean output = validator.validateUsername(username);
        assertFalse(output);
    }

    @org.junit.Test
    public void testNullString() {
        String username = null;
        boolean output = validator.validateUsername(username);
        assertFalse(output);
    }
}
