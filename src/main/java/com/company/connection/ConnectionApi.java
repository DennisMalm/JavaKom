package com.company.connection;

import com.company.model.PokemonJson;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionApi {

    //  Singleton connection to API
    private String urlPokemon = "https://pokeapi.co/api/v2/pokemon/";
    private static ConnectionApi instance = new ConnectionApi();

    private ConnectionApi() {
    }

    public static ConnectionApi getInstance() {
        if (instance == null)
            instance = new ConnectionApi();
        return instance;
    }

    private String conn(String url) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (isJson(response.body())) {
            ConnectionMongo.INSTANCE.addRecord(response.body());
            return response.body();
        } else {
            return null;
        }

    }

    public PokemonJson getPokemon(String endPoint) throws IOException, InterruptedException {
        return new Gson().fromJson(conn(urlPokemon + endPoint), PokemonJson.class);
    }

    public static boolean isJson(String Json) {
        Gson gson = new Gson();
        try {
            gson.fromJson(Json, Object.class);
            Object jsonObjType = gson.fromJson(Json, Object.class).getClass();
            if (jsonObjType.equals(String.class)) {
                return false;
            }
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

}
