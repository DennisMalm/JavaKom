package com.company.controller;


import com.company.entity.Pokemon;
import com.company.service.PokemonService;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Data
@NoArgsConstructor
public class PokemonController {

    private PokemonService pokemonService = new PokemonService();

    public Pokemon createPokemon(String name) throws IOException, InterruptedException {
        checkDataBase();
        Pokemon pokemon = pokemonService.createPokemon(name);
        return pokemon;
    }
}
