package com.company;


import com.company.entity.PokemonJson;
import com.company.entity.PokemonMovesJson;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        // test test test
        System.out.println("1. Get bulbasaur.\n2. Get charmander.\n3. Get squirtle.");

        boolean stop = false;
        String pokemonToGet = null;
        Scanner read = new Scanner(System.in);
        int input = read.nextInt();

        while (!stop) {

            switch (input) {
                case 1:
                    pokemonToGet = "bulbasaur";
                    stop = true;
                    break;
                case 2:
                    pokemonToGet = "charmander";
                    stop = true;
                    break;
                case 3:
                    pokemonToGet = "squirtle";
                    stop = true;
                    break;
                default:
                    System.out.println("Wrong input.");
                    break;
            }
        }
        Connection conn = new Connection();


        PokemonJson pokemon = conn.getPokemon(pokemonToGet);
        pokemon.getPokeInfo();
        System.out.println(pokemon.getMoves().get(0).getMove().getUrl());
        PokemonMovesJson move = conn.getMove(pokemon.moves.get(0).getMove().getUrl());

        move.moveInfo();


        /*while (true) {
            pokemonToGet = read.nextLine().toLowerCase();

            if (!pokemonToGet.matches("[a-zA-Z_]+")) {
                System.out.println("Invalid name.");
                continue;
            }
            System.out.println(String.format("Fetching pokemon %s...", pokemonToGet));
            break;
        }*/
    }
}
