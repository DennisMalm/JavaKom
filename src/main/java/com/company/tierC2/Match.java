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
        Pokemon attackFirst = pokeOne.getSpeed() > pokeTwo.getSpeed() ? pokeOne : pokeTwo;
        Pokemon attackSecond = attackFirst == pokeOne ? pokeTwo : pokeOne;

        System.out.println(attackFirst.getName() + " attacks first with a speed of " + attackFirst.getSpeed());
        System.out.println(attackSecond.getName() + " attacks first with a speed of " + attackSecond.getSpeed());

        while(true){

            if(attackFirst.attack(attackSecond)){
                logResults(attackFirst,attackSecond);
                break;
            } else if(attackSecond.attack(attackFirst)){
                logResults(attackSecond, attackFirst);
                break;
            }
        }
    }
    public void logResults (Pokemon winner, Pokemon loser){
        this.winners.add(winner);
        this.losers.add(loser);
        System.out.println("Winner: " + winners.get(0).getName());
        System.out.println("Loser: " + losers.get(0).getName());
    }
}
