package com.company.creator;


import com.company.Utility;
import com.company.connection.ConnectionApi;
import com.company.entity.Moves;
import com.company.entity.MovesJson;
import com.company.entity.Pokemon;
import com.company.entity.PokemonJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PokemonService {

    ConnectionApi connectionApi = ConnectionApi.getInstance();

    public Pokemon pokemonExists() throws IOException, InterruptedException {
        String name = Utility.validInput();
        return createPokemon(name);
    }

    public Pokemon createPokemon(String name) throws IOException, InterruptedException {
        PokemonJson pokemonJson = connectionApi.getPokemon(name);
        return new Pokemon(pokemonJson, createMoveSet(pokemonJson));
    }

    public List<Moves> createMoveSet(PokemonJson pokemonJson) throws IOException, InterruptedException {
        List<String> moveList = pokemonJson.moveUrl();
        List<Moves> movesJavaList = new ArrayList<>();

        if (!moveList.isEmpty()) {
            for (String moveUrl : moveList) {
                connectionApi.getMove(moveUrl);
                MovesJson movesJson = connectionApi.getMove(moveUrl);
                Moves movesJava = new Moves(movesJson);
                movesJavaList.add(movesJava);
            }
        } else System.out.println(Utility.fetchFail);
        return movesJavaList;
    }

}

