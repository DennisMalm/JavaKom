package com.company.tierC2;

import com.company.tierB2.Roster;
import com.company.tierC.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Match {

    Roster roster = Roster.getInstance();
    List<Pokemon> winners = new ArrayList<>();
    List<Pokemon> losers = new ArrayList<>();

    public void fight(Pokemon pokeOne, Pokemon pokeTwo) {
        int size = roster.getArray().size();
        if (size < 2) {
            System.out.println("You have " + size + " fighters, add " + (8 - size) + " more.");
        }

        boolean stop = false;
        while (true) {

            if (pokeOne.attack(pokeTwo)){
                winners.add(pokeOne);
                losers.add(pokeTwo);
                break;
            } else if (pokeTwo.attack(pokeOne)) {
                winners.add(pokeTwo);
                losers.add(pokeOne);
                break;
            }
        }
        System.out.println("Winner: " + winners.get(0).getName());
        System.out.println("Loser: " + losers.get(0).getName());
    }

}
