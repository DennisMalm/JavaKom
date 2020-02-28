package com.company.service;

import com.company.connection.ConnectionApi;
import com.company.connection.ConnectionMongo;
import com.company.model.Pokemon;

import java.io.IOException;

public class PokemonService {

    //TODO Observer here notifying if Pokemon was imported from local DB or API

    ConnectionApi connectionApi = ConnectionApi.getInstance();
    ConnectionMongo connectionMongo = ConnectionMongo.INSTANCE;

    public Pokemon createPokemon(String name) throws IOException, InterruptedException {
        if (connectionMongo.searchRecord(name)){
            return new Pokemon(connectionMongo.getPokemon(name));
        } else {
            return new Pokemon(connectionApi.getPokemon(name));
        }

    }

}

