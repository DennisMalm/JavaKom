package com.company;


import com.company.pokemon.PokemonJson;
import com.google.gson.Gson;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ApiConnection {

    private String responseJson;
    private String requestPokemon = "https://pokeapi.co/api/v2/pokemon/";
    private String requestMove = "https://pokeapi.co/api/v2/";

    public ApiConnection(String endPoint) throws IOException, InterruptedException {

        requestPokemon += endPoint;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestPokemon))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        this.responseJson = response.body();
    }


    public void printResponseBody() {
        System.out.println(responseJson);
    }

    public PokemonJson jsonToJava() throws IOException {

        PokemonJson pokemonJson = null;
        try {
            pokemonJson = new Gson().fromJson(responseJson, PokemonJson.class);
        } catch (IllegalStateException ISE) {
            System.out.println("That pokemon does not exist!");
        }
        assert pokemonJson != null;
        System.out.println(pokemonJson.getName() + " is the name of the pokemon object.");
        pokemonJson.getPokeInfo();
        return pokemonJson;
        
    }
}
