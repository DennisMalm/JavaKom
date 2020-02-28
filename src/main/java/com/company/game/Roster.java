package com.company.game;

import com.company.model.Pokemon;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Roster {
    private static Roster rosterInstance;
    private ArrayList<Pokemon> roster = null;
    private int maxSize;

    private Roster() {
        roster = new ArrayList<Pokemon>();
        maxSize = 8;
    }
    public static Roster getInstance() {
        if(rosterInstance == null)
            rosterInstance = new Roster();
        return rosterInstance;
    }

    //  Retrieve array from anywhere
    public ArrayList<Pokemon> getArray() {
        return this.roster;
    }
    //  Add element to array
    public void addToArray(Pokemon pokemon) {
        if (this.roster.size() < maxSize)
        roster.add(pokemon);
        else System.out.println("Roster is full.");
    }
    //  Loop through and print info on all pokemons in roster
    public void loopArray(){
        roster.forEach(Pokemon::testInfo);
    }
    //  Remove an element from roster
    public void removeFighter(Pokemon pokemon){
        roster.remove(pokemon);
    }
    //  Get a specific element from roster
    public Pokemon getFighter(int index){
        return roster.get(index);
    }
}
