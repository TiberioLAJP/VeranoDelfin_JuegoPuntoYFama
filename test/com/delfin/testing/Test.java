/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delfin.testing;

import com.delfin.classes.Numbers;

/**
 *
 * @author tibe
 */
public class Test {

    public static void main(String[] args) {

        Numbers numbers = new Numbers();
        numbers.setNumberOfDigits(3);
        numbers.generateRandomNumber();
    }
}
