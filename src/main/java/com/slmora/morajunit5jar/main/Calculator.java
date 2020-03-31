/**
 * Created by IntelliJ IDEA.
 * Author: SLMORA
 * Date Time: 2/22/2020 3:10 PM
 */
package com.slmora.morajunit5jar.main;

/**
 * This class created for learn the Junit 5 testing process with mathematical operations
 */
public class Calculator {

    public int add(int input1, int input2){
         return input1+input2;
    }

    public double getAreaOfCircle(double radious){
        return Math.PI*Math.pow(radious,2);
//        return 0;
    }

    public int devide(int input1, int input2){
        return input1/input2;
    }
}
/**
 *
 */