/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 2/22/2020 3:12 PM
 */
package com.slmora.morajunit5jar.main;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This Class related with com.slmora.morajunit5jar.main.Calculator for testing
 *
 * @Author: SLMORA
 * @DateTime: 2/22/2020 3:12 PM
 *
 * Version      Date            Editor              Note
 * ---------    ----------      ----------------    --------------------------------------------------------------------
 * 1.0          2020-02-22      MORA                Initial Code
 *
 */
public class CalculatorTest
{

    /**
     * Test the add() method with input values 1, 2 for expected 3
     * */
    @Test
    public void testAdd01()
    {
        Calculator cal=new Calculator();
        int expected = 3;
        int result = cal.add(1, 2);
        assertEquals(expected, result);
    }

    /**
     * Test the add() method with input values 1, 2 for expected 2
     * */
    @Test
    @Disabled
    public void testAdd02()
    {
        Calculator cal=new Calculator();
        int expected = 2;
        int result = cal.add(1, 2);
        assertEquals(expected, result);
    }

    /**
     * Test the add() method with input values 1, 2 for expected 3 with comment
     * */
    @Test
    public void testAdd03()
    {
        Calculator cal=new Calculator();
        int expected = 3;
        int result = cal.add(1, 2);
        assertEquals(expected, result, "Add method should add two numbers");
    }

    /**
     * Practice of TDD test driven development planing to create method for get area of the circle
     * Test the getAreaOfCircle() method with input radius values 3 for expected 28.274333882308138 with comment
     * */
    @Test
    public void testGetAreaOfCircle01()
    {
        Calculator cal=new Calculator();
        double expected = 28.274333882308138;
        double result = cal.getAreaOfCircle(3);
        assertEquals(expected, result, "Get area of the circle for given radius");
    }

    /**
     * Test the devide() method with input values 4, 2 for expected 2 with comment
     * */
    @Test
    public void testDevide01()
    {
        Calculator cal=new Calculator();
        int expected = 2;
        int result = cal.devide(4, 2);
        assertEquals(expected, result, "Device method should devide two numbers");
    }

    /**
     * Test the devide() method with input values 4, 0 for expected 'java.lang.ArithmeticException' with comment
     * */
    @Test
    public void testDevide02()
    {
        Calculator cal=new Calculator();
        assertThrows(ArithmeticException.class,
                () -> cal.devide(4, 0),
                "Device method should devide two numbers");
    }
}
/*
 *
 */