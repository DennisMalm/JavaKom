package com.company.connection;

import com.company.tierC.MovesJson;
import com.company.tierC.PokemonJson;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionApi {

    //  API endpoint URL.
    private String urlPokemon = "https://pokeapi.co/api/v2/pokemon/";
    //  Singleton instance of connection with API.
    private static ConnectionApi instance = new ConnectionApi();

    private ConnectionApi() {
    }

    public static ConnectionApi getInstance() {
        if(instance == null)
            instance = new ConnectionApi();
        return instance;
    }

    private String conn(String url) throws IOException, InterruptedException {


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        //  Insert into local DB if not exists
        ConnectionMongo.INSTANCE.addRecord(response.body());
        return response.body();
    }

    public PokemonJson getPokemon(String endPoint) throws IOException, InterruptedException {
        return new Gson().fromJson(conn(urlPokemon + endPoint), PokemonJson.class);
    }

    public MovesJson getMove(String endPoint) throws IOException, InterruptedException {
        return new Gson().fromJson(conn(endPoint), MovesJson.class);
    }

}
