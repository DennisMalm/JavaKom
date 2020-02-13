package com.company.retrieval;

import com.company.entity.MovesJson;
import com.company.entity.PokemonJson;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {

    //  API endpoint URL.
    private String urlPokemon = "https://pokeapi.co/api/v2/pokemon/";

    //  Singelton instance of connection with API.
    private static Connection instance = new Connection();

    private Connection() {}

    public static Connection getInstance() {
        return instance;
    }

    private String conn(String url) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public PokemonJson getPokemon(String endPoint) throws IOException, InterruptedException {
        return new Gson().fromJson(conn(urlPokemon + endPoint), PokemonJson.class);
    }

    public MovesJson getMove(String endPoint) throws IOException, InterruptedException {
        return new Gson().fromJson(conn(endPoint), MovesJson.class);
    }

}
