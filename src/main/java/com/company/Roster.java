package com.company;

import java.util.ArrayList;
import java.util.List;

public class Roster {

    List<Pokemon> fighterList = new ArrayList<>();

    public void addFighter(Pokemon fighter){
        fighterList.add(fighter);
    }
    public void getFighters(int max, int min){

        int fighterOne = (int)(Math.random()*((max-min)+1))+min;

    }
}
