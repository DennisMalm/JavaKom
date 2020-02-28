package com.company.game;

import com.company.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Match {

    Roster roster = Roster.getInstance();
    List<Pokemon> winners = new ArrayList<>();
    List<Pokemon> losers = new ArrayList<>();

    public boolean matchSetup(){
        int size = roster.getArray().size();
        Pokemon fighterOne;
        Pokemon fighterTwo;
        if (size < 4) {
            System.out.println("You have " + size + " fighters, add " + (8 - size) + " more.");
            return false;
        }
        do {
            fighterOne = roster.getRoster().get((int) (Math.random() * roster.getRoster().size()));
            do {
                fighterTwo = roster.getRoster().get((int) (Math.random() * roster.getRoster().size()));
            } while (fighterOne.getName().equals(fighterTwo.getName()));
            fight(fighterOne, fighterTwo);
            if (roster.getRoster().size() == 0) {
                winners.forEach(winner -> roster.addToArray(winner));
                roster.getRoster().forEach(Pokemon::reset);
                winners.clear();
            }
        } while (roster.getRoster().size() > 0);

        return true;
    }

    public boolean fight(Pokemon pokeOne, Pokemon pokeTwo) {
        System.out.println("\n" + pokeOne.getName() + " vs. " + pokeTwo.getName() + "\n--------------------------");
        Pokemon attackFirst = pokeOne.getSpeed() > pokeTwo.getSpeed() ? pokeOne : pokeTwo;
        Pokemon attackSecond = attackFirst == pokeOne ? pokeTwo : pokeOne;

        while(true){

            if(attackFirst.attack(attackSecond)){
                logResults(attackFirst,attackSecond);
                break;
            } else if(attackSecond.attack(attackFirst)){
                logResults(attackSecond, attackFirst);
                break;
            }
        }
        return true;
    }
    public void logResults (Pokemon winner, Pokemon loser){
        this.winners.remove(loser);
        this.winners.add(winner);
        this.losers.add(loser);
        roster.removeFighter(winner);
        roster.removeFighter(loser);
        System.out.println("Winner: " + winner.getName());
        System.out.println("Loser: " + loser.getName());
    }
}
