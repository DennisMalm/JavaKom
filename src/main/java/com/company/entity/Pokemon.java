package com.company.entity;

import jdk.jshell.StatementSnippet;

import java.util.HashMap;
import java.util.List;

public class Pokemon {

    private String name;
    private HashMap stats;
    private List types;
    private List<Moves> moves;

    public Pokemon(PokemonJson pokemonJson, List<Moves> moves) {
        this.name = pokemonJson.getName();
        this.stats = pokemonJson.getStats();
        this.types = pokemonJson.getType();
        this.moves = moves;


    }

    public void testInfo() {
        System.out.println("This is an Java Objekt.");
        System.out.println(types.size());
        System.out.println(name + "\nTypes:");
        types.forEach(System.out::println);
        System.out.println("Special attack: " + stats.get("special-attack"));
        moves.forEach(move -> System.out.println(move.getName() + move.getPower()) );


    }


}
