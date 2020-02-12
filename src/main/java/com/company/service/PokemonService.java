package com.company.service;


import com.company.doa.ApiConnection;
import com.company.entity.Pokemon;
import com.company.entity.PokemonJson;

import java.io.IOException;


public class PokemonService {

    ApiConnection connection = new ApiConnection();

    public Pokemon createPokemon(String name) throws IOException, InterruptedException {

        PokemonJson pokemonJson = connection.getPokemon(name);

        Pokemon pokemon = new Pokemon(pokemonJson);
        return pokemon;
    }

}

