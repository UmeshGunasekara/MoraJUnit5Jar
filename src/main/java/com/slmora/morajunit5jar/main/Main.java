/**
 * Created by IntelliJ IDEA.
 * Author: SLMORA
 * Date Time: 2/22/2020 3:13 PM
 */
package com.slmora.morajunit5jar.main;

/**
 * This class of the main class of the application
 */
public class Main {

    /**
     * The main method of the application
     */
    public static void main(String[] args) {
        Calculator cal=new Calculator();
        int result=cal.add(1, 2);

        if(result == 3){
            System.out.println("Test Pass");
        }else{
            System.out.println("Test fail");
        }

        System.out.println(cal.devide(2,0));


    }
}
/**
 *
 */