/**
 * Created by IntelliJ IDEA.
 * Author: SLMORA
 * Date Time: 2/23/2020 11:27 AM
 */
package com.slmora.morajunit5jar.main;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This Class related with com.slmora.morajunit5jar.main.Calculator for testing
 * Learn for manage the LifeCycle of test instance creation
 */
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)//Default
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest3 {
    Calculator cal;

    /**
     * This method runs before all Test Cases
     * This must be static because of this will execute before crete s the instance of this class
     * If the Lifecycle is PER_CLASS the BeforeAll dont want to be static
     * */
    @BeforeAll
    public void beforeAllInit(){
        System.out.println("Before All Initiated........");
    }

    /**
     * Initiate the Calculator object before each test execution
     * */
    @BeforeEach
    private void beforeEachInit(){
        this.cal=new Calculator();
        System.out.println("Before Each Calculator Initiated........");
    }

    /**
     * Runs this method after each test execution
     * */
    @AfterEach
    private void afterEachEnd(){
        System.out.println("After Each Clean Test........");
    }

    /**
     * Test the add() method with input values 1, 2 for expected 3
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    public void testAdd01(){
        int expected = 3;
        int result = cal.add(1, 2);
        assertEquals(expected, result);
    }

    /**
     * Test the add() method with input values 1, 2 for expected 2
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Disabled
    public void testAdd02(){
        int expected = 2;
        int result = cal.add(1, 2);
        assertEquals(expected, result);
    }

    /**
     * Test the add() method with input values 1, 2 for expected 3 with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    public void testAdd03(){
        int expected = 3;
        int result = cal.add(1, 2);
        assertEquals(expected, result, "Add method should add two numbers");
    }

    /**
     * Practice of TDD test driven development planing to create method for get area of the circle
     * Test the getAreaOfCircle() method with input radius values 3 for expected 28.274333882308138 with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    public void testGetAreaOfCircle01(){
        double expected = 28.274333882308138;
        double result = cal.getAreaOfCircle(3);
        assertEquals(expected, result, "Get area of the circle for given radius");
    }

    /**
     * Test the devide() method with input values 4, 2 for expected 2 with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    public void testDevide01(){
        int expected = 2;
        int result = cal.devide(4, 2);
        assertEquals(expected, result, "Device method should devide two numbers");
    }

    /**
     * Test the devide() method with input values 4, 0 for expected 'java.lang.ArithmeticException' with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    public void testDevide02(){
        assertThrows(ArithmeticException.class,
                () -> cal.devide(4, 0),
                "Device method should devide two numbers");
    }

    /**
     * This method runs After all Test Cases execution
     * This must be static because of this will execute after instance destroyed
     * If the Lifecycle is PER_CLASS the AfterAll dont want to be static
     * */
    @AfterAll
    public void AfterAllInit(){
        System.out.println("After All Initiated........");
    }
}
/**
 *
 */