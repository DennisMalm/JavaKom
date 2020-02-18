package com.company;


import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {

        boolean stop;
        do {
            stop = Menu.menu();
        } while (!stop);

        /*Connection conn = new Connection();


        PokemonJson pokemon = conn.getPokemon(pokemonToGet);
        pokemon.getPokeInfo();
        System.out.println(pokemon.getMoves().get(0).getMove().getUrl());
        MovesJson move = conn.getMove(pokemon.moves.get(0).getMove().getUrl());

        move.moveInfo();*/


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
