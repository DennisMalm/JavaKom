package com.company.doa;

import com.company.entity.MovesJson;
import com.company.entity.PokemonJson;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnection {

    private String jsonResponse;
    private String urlPokemon = "https://pokeapi.co/api/v2/pokemon/";
    private String urlMove = "https://pokeapi.co/api/v2/";

    public PokemonJson getPokemon(String endPoint) throws IOException, InterruptedException {
        PokemonJson pokemon = new Gson().fromJson(conn(urlPokemon + endPoint), PokemonJson.class);
        return pokemon;
    }

    public MovesJson getMove(String endPoint) throws IOException, InterruptedException {
        MovesJson move = new Gson().fromJson(conn(endPoint), MovesJson.class);
        return move;
    }

    public String conn (String url) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
