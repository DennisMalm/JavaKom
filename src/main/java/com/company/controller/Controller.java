package com.company.controller;

import com.company.competition.Match;
import com.company.competition.Roster;
import com.company.creator.PokemonService;
import com.company.entity.Pokemon;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Data
@NoArgsConstructor
public class Controller {

    private PokemonService pokemonService = new PokemonService();

    private Roster roster = Roster.getInstance();
    private Match match = new Match();

    //TODO fix observer to check if called item from API already exists in local database.
    public void createPokemon() throws IOException, InterruptedException {

        roster.addToArray(pokemonService.pokemonExists());
       // return pokemonService.pokemonExists();
    }

    public void checkRoster(){
        roster.loopArray();
    }
    public void startMatch(){
        Pokemon pokeOne = roster.getFighter(0);
        Pokemon pokeTwo = roster.getFighter(1);
        match.fight(pokeOne, pokeTwo);
    }

    /*public Pokemon createPokemon(String name) throws IOException, InterruptedException {
        return pokemonService.createPokemon(name);
    }*/

}
