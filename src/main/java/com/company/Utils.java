package com.company;

import java.util.Random;

public class Utils {

    static final String pokeInfoFormat = "Name:\t\t\tType:";

    public int getRandomNum(int max, int min){

        return (int)(Math.random()*((max-min)+1))+min;
    }
}
