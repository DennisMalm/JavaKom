package com.company.tierB;


import com.company.Utility;
import com.company.connection.ConnectionApi;
import com.company.connection.ConnectionMongo;
import com.company.tierC.Moves;
import com.company.tierC.MovesJson;
import com.company.tierC.Pokemon;
import com.company.tierC.PokemonJson;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PokemonService {

    ConnectionApi connectionApi = ConnectionApi.getInstance();
    ConnectionMongo connectionMongo = ConnectionMongo.INSTANCE;

    public Pokemon pokemonExists() throws IOException, InterruptedException {
        String name = Utility.validInput();
        if (connectionMongo.searchRecord(name)) {

            return importPokemon(name);
        }
        //return null;
        return createPokemon(name);
    }

    public Pokemon createPokemon(String name) throws IOException, InterruptedException {
        PokemonJson pokemonJson = connectionApi.getPokemon(name);
        return new Pokemon(pokemonJson, createMoveSet(pokemonJson));
    }
    public Pokemon importPokemon(String name) throws IOException, InterruptedException {
        ConnectionMongo.INSTANCE.getPokemon(name);
       PokemonJson pokemonJson = connectionMongo.getPokemon(name);
       return new Pokemon(pokemonJson, createMoveSet(pokemonJson));
    }
    /*public List<Moves> importMoveSet(PokemonJson){
        return
    }*/
    //TODO Search DB for move and add
    public List<Moves> createMoveSet(PokemonJson pokemonJson) throws IOException, InterruptedException {
        List<String> moveList = pokemonJson.moveUrl();
        List<Moves> movesJavaList = new ArrayList<>();

        if (!moveList.isEmpty()) {
            String url = moveList.get(2);
            MovesJson movesJson = connectionApi.getMove(url);
            Moves movesJava = new Moves(movesJson);
            movesJavaList.add(movesJava);

        } else System.out.println(Utility.fetchFail);
        return movesJavaList;
    }

}

