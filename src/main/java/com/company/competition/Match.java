package com.company.competition;

import com.company.entity.Pokemon;

public class Match {

    Roster roster = Roster.getInstance();
    public void fight(Pokemon pokeOne, Pokemon pokeTwo) {
        int size = roster.getArray().size();
        if (size < 2) {
            System.out.println("You have " + size + " fighters, add " + (8 - size) + " more.");
        }
        boolean stop = false;
        while (!stop) {
            stop = pokeOne.attack(pokeTwo);
            stop = pokeTwo.attack(pokeOne);
        }
    }




}
