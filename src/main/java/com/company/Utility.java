package com.company;

import java.util.Scanner;

public class Utility {

    public static final String reTry = "Incorrect input, try again...";
    public static final String fetchFail = "Cannot fetch requested items.";
    public static final String fetchPokemon = "which pokemon would you like to add to the roster?";
    public static final String testString = "This is a test...";


    //  Stats
    public static final String specialAttack = "Special attack";

    //  Methods
    public static String validInput() {
        while (true) {
            Scanner read = new Scanner(System.in);
            System.out.println(fetchPokemon);
            String validName = read.nextLine();
            if (validName.isEmpty()) {
                System.out.println(fetchFail);
                continue;
            }
            return validName;

        }
    }
    public double randomNumber(int max, int min){
        double random = (Math.random()*((max-min)+1))+min;
        System.out.println(random);
        return random;
    }

}
