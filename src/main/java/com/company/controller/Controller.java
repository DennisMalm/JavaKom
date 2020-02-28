package com.company.controller;

import com.company.Utility;
import com.company.game.Match;
import com.company.game.Roster;
import com.company.service.PokemonService;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Controller {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }


    private PokemonService pokemonService = new PokemonService();
    private Roster roster = Roster.getInstance();
    private Match match = new Match();

    public void createPokemon() throws IOException, InterruptedException {
        if (roster.getRoster().size() == roster.getMaxSize()) {
            System.out.println("Roster is full.");
        } else {
            try {
                roster.addToArray(pokemonService.createPokemon(Utility.validString()));
            } catch (NullPointerException npe) {
                System.out.println(Utility.fetchFail);
            }
        }
    }

    public void checkRoster() {
        roster.loopArray();
    }

    public void startMatch() {
        /*Pokemon pokeOne = roster.getFighter(0);
        Pokemon pokeTwo = roster.getFighter(1);*/
        match.matchSetup();
    }

}
