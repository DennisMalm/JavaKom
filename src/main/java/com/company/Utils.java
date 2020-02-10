package com.company;

import java.util.Random;

public class Utils {

    public int getRandomNum(int max, int min){

        return (int)(Math.random()*((max-min)+1))+min;
    }
}
