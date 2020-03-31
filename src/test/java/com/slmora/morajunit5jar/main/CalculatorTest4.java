/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 2/23/2020 7:15 PM
 */
package com.slmora.morajunit5jar.main;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * This Class related with com.slmora.morajunit5jar.main.Calculator for testing
 * Learn dependency injection of the JUnit 5 about TestInfo and TestReporter
 *
 * @Author: SLMORA
 * @DateTime: 2/23/2020 7:15 PM
 *
 * Version      Date            Editor              Note
 * ---------    ----------      ----------------    --------------------------------------------------------------------
 * 1.0          2020-02-23      SLMORA                Initial Code
 *
 */
public class CalculatorTest4
{
    Calculator cal;
    TestInfo testInfo;
    TestReporter testReporter;

    /**
     * This method runs before all Test Cases
     * This must be static because of this will execute before crete s the instance of this class
     * */
    @BeforeAll
    public static void beforeAllInit()
    {
        System.out.println("Before All Initiated........");
    }

    /**
     * Initiate the Calculator object before each test execution
     * */
    @BeforeEach
    private void beforeEachInit(
            TestInfo testInfo,
            TestReporter testReporter)
    {
        this.testInfo=testInfo;
        this.testReporter=testReporter;
        this.cal=new Calculator();
        System.out.println("Before Each Calculator Initiated........");
//        System.out.println("Running "+testInfo.getDisplayName()+" with tags "+testInfo.getTags());
        testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tags "+testInfo.getTags());
    }

    /**
     * Runs this method after each test execution
     * */
    @AfterEach
    private void afterEachEnd()
    {
        System.out.println("Test Completed "+testInfo.getDisplayName());
        System.out.println("After Each Clean Test........");
    }

    /**
     * Test the add() method with input values 1, 2 for expected 3
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Tag("Math")
    @DisplayName("Test Add Method with input values 1, 2 for Expected 3")
    public void testAdd01()
    {
        int expected = 3;
        int result = cal.add(1, 2);
        assertEquals(expected, result);
    }

    /**
     * Test the add() method with input values 1, 2 for expected 2
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Tag("Math")
    @DisplayName("Test Add Method with input values 1, 2 for Expected 2")
    @Disabled
    public void testAdd02()
    {
        int expected = 2;
        int result = cal.add(1, 2);
        assertEquals(expected, result);
    }

    /**
     * Test the add() method with input values 1, 2 for expected 3 with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Tag("Math")
    @DisplayName("Test Add Method with input values 1, 2 for Expected 3 with Comment")
    public void testAdd03()
    {
        int expected = 3;
        int result = cal.add(1, 2);
        assertEquals(expected, result, "Add method should add two numbers");
    }

    /**
     * Test the add() method for repeated test
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
//    @Test
    @RepeatedTest(3)
    @Tag("Math")
    @DisplayName("Test Add Method with input values 1, 2 for Expected 3 with Comment 3 time repeat")
    public void testAdd04()
    {
        int expected = 3;
        int result = cal.add(1, 2);
        assertEquals(expected, result, "Add method should add two numbers");
    }

    /**
     * Test the add() method for repeated test with repetition Info
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
//    @Test
    @RepeatedTest(4)
    @Tag("Math")
    @DisplayName("Test Add Method with input values 1, 2 for Expected 3 with Comment")
    public void testAdd05(RepetitionInfo repetitionInfo)
    {
        if(repetitionInfo.getCurrentRepetition()==1){
            int expected = 4;
            int result = cal.add(2, 2);
            assertEquals(expected, result, "Add method should add two numbers");
        }else{
            int expected = 3;
            int result = cal.add(1, 2);
            assertEquals(expected, result, "Add method should add two numbers");
        }

    }

    /**
     * Test case taging tages test case can manage as a run configuration in maven-surefire-plugin in <excludes>
     * Test the add() method with input values 1, 2 for expected 3 with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Tag("Math")
    @DisplayName("Test Add Method Taged 'Math' with input values 1, 2 for Expected 3 with Comment")
    public void testAdd06()
    {
        int expected = 3;
        int result = cal.add(1, 2);
        assertEquals(expected, result, "Add method should add two numbers");
    }

    /**
     * Test the add() method in separate section of test cases
     * This will run as a nested test cases
     * */
    @Nested
    @DisplayName("Testing of the method add()")
    class AdddTest
    {
        /**
         * Test the add() method with input values 2, 2 for expected 4 with comment
         * */
        @Test
        @Tag("Math")
        @DisplayName("Test Add Method with input values 2, 2 for Expected 3 with Comment")
        public void testAddSub01()
        {
            int expected = 4;
            int result = cal.add(2, 2);
            assertEquals(expected, result, "Add method should add two numbers");
        }

        /**
         * Test the add() method with input values -2, -2 for expected -4 with comment
         * */
        @Test
        @Tag("Math")
        @DisplayName("Test Add Method with input values -2, -2 for Expected -4 with Comment")
        public void testAddSub02()
        {
            int expected = -4;
            int result = cal.add(-2, -2);
            assertEquals(expected, result, "Add method should add two numbers");
        }
    }

    /**
     * Practice of TDD test driven development planing to create method for get area of the circle
     * Test the getAreaOfCircle() method with input radius values 3 for expected 28.274333882308138 with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Tag("Geometry")
    @DisplayName("Test Get Area of Circle Method with input radius 3 for Expected 28.274333882308138 with comment")
    public void testGetAreaOfCircle01()
    {
        double expected = 28.274333882308138;
        double result = cal.getAreaOfCircle(3);
        assertEquals(expected, result, "Get area of the circle for given radius");
    }

    /**
     * Practice of TDD test driven development planing to create method for get area of the circle
     * Test the getAreaOfCircle() method with input radius values 3 for expected 28.284333882308138 with comment
     * If the value of PI different in OS linux this test case mut run only OS Linux
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Tag("Geometry")
    @DisplayName("Test Get Area of Circle Method in OS LINUX with input radius 3 for Expected 28.274333882308138 with comment")
    @EnabledOnOs(OS.LINUX)
    public void testGetAreaOfCircle02()
    {
        double expected = 28.284333882308138;
        double result = cal.getAreaOfCircle(3);
        assertEquals(expected, result, "Get area of the circle for given radius");
    }

    /**
     * Practice of TDD test driven development planing to create method for get area of the circle
     * Test the getAreaOfCircle() method with input radius values 2 for expected 12.56 with comment
     * If the value of PI different nd we assume that the Math.PI value is 3.14 then  we want only run this if it is true
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Tag("Geometry")
    @DisplayName("Test Get Area of Circle Method Assumimg PI = 3.14 with input radius 2 for Expected 12.56 with comment")
    public void testGetAreaOfCircle03()
    {
        assumeTrue(Math.PI==3.14);
        double expected = 12.56;
        double result = cal.getAreaOfCircle(2);
        assertEquals(expected, result, "Get area of the circle for given radius");
    }

    /**
     * Best Practice of pass error message use passing error message as a Supplier lamda
     * When we use this method if the test success the message string will not create it can save some memory and effect on performance
     * Test the getAreaOfCircle() method with input radius values 2 for expected 12.56 with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Disabled
    @Tag("Geometry")
    @DisplayName("Test Get Area of Circle Method Assumimg PI = 3.14 with input radius 2 for Expected 12.56 with Supplier comment")
    public void testGetAreaOfCircle04()
    {
        double expected = 12.56;
        double result = cal.getAreaOfCircle(2);
        assertEquals(expected, result, () -> "Get area of the circle for given radius 2 expected "+expected+" but result is "+result);
    }


    /**
     * Test the devide() method with input values 4, 2 for expected 2 with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Tag("Math")
    @DisplayName("Test Devide Method with input values 4, 2 for Expected 2 with comment")
    public void testDevide01()
    {
        int expected = 2;
        int result = cal.devide(4, 2);
        assertEquals(expected, result, "Device method should devide two numbers");
    }

    /**
     * Test the devide() method with input values 4, 0 for expected 'java.lang.ArithmeticException' with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Tag("Math")
    @DisplayName("Test Devide Method with input values 4, 0 for Expected ArithmeticException with comment")
    public void testDevide02()
    {
        assertThrows(ArithmeticException.class,
                () -> cal.devide(4, 0),
                "Device method should devide two numbers");
    }

    /**
     * Test the devide() method with input values 4, 0 for expected 'java.lang.ArithmeticException' with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Tag("Math")
    @DisplayName("Test Devide Method in JRE 8 with input values 4, 0 for Expected ArithmeticException with comment")
    @EnabledOnJre(JRE.JAVA_8)
    public void testDevide03()
    {
        assertThrows(ArithmeticException.class,
                () -> cal.devide(4, 0),
                "Device method should devide two numbers");
    }

    /**
     * Test the devide() method with test with multiple cases
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * */
    @Test
    @Tag("Math")
    @DisplayName("Test Devide Method For multiple assertions")
    public void testDevide04()
    {
        assertAll(
                () -> assertThrows(ArithmeticException.class,
                        () -> cal.devide(4, 0),
                        "Device method should devide two numbers"),
                () -> assertEquals(2, cal.devide(4, 2)),
                () -> assertEquals(2, cal.devide(5, 2))
        );

    }

    /**
     * Test the multiply() method with input values 4, 2 for expected 8 with comment
     * Removed the Calculator object initialization to init() method which annotated by @BeforeEach
     * This is in TDD not implemented case yet so made as a disabled method
     * */
    @Test
    @Tag("Math")
    @DisplayName("Not Implemented yet Test Multiply Method with input values 4, 2 for Expected 8 with comment")
    @Disabled
    public void testMultiply01()
    {
        fail("This is in TDD not implemented case yet so made as a disabled method");
    }

    /**
     * This method runs After all Test Cases execution
     * This must be static because of this will execute after instance destroyed
     * */
    @AfterAll
    public static void AfterAllInit()
    {
        System.out.println("After All Initiated........");
    }
}
/*
 *
 */