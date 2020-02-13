package com.company.service;


import com.company.doa.ApiConnection;
import com.company.entity.Moves;
import com.company.entity.MovesJson;
import com.company.entity.Pokemon;
import com.company.entity.PokemonJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PokemonService {

    ApiConnection connection = new ApiConnection();

    public Pokemon createPokemon(String name) throws IOException, InterruptedException {

        PokemonJson pokemonJson = connection.getPokemon(name);

        //List<Moves> moves = createMoveSet(pokemonJson);

        Pokemon pokemon = new Pokemon(pokemonJson, createMoveSet(pokemonJson));


        return pokemon;
    }

    public List<Moves> createMoveSet(PokemonJson pokemonJson) throws IOException, InterruptedException {
        List<String> moveList = pokemonJson.moveUrl();

        //List<MovesJson> movesJsonList = null;
        List<Moves> movesJavaList = new ArrayList<>();

        if (!moveList.isEmpty()) {

            for (String moveUrl : moveList) {

                connection.getMove(moveUrl);
                MovesJson movesJson = connection.getMove(moveUrl);
                Moves movesJava = new Moves(movesJson);
                movesJavaList.add(movesJava);

            }
        } else {
            System.out.println("No moves to get.");
        }
        return movesJavaList;
    }

}

