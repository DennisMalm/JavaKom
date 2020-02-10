package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
	PokeApi get = new PokeApi();
    get.pokemonToGet();
    }
}
