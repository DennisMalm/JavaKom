package com.company;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PokeApi {

    void pokemonToGet() throws IOException, InterruptedException {
        System.out.println("1. Get bulbasaur.\n2. Get charmander");

        Scanner read = new Scanner(System.in);
        int input = read.nextInt();
        switch (input) {
            case 1:
                System.out.println("Getting bulbasaur...");
                setConnectionHttPClient("bulbasaur");
                break;
            case 2:
                System.out.println("Getting charmander...");
                setConnectionHttPClient("charmander");
                break;
        }
    }

    void setConnectionHttPClient(String name) throws IOException, InterruptedException {
        String requestString = "https://pokeapi.co/api/v2/pokemon/" + name;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestString))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        String content = response.body();
        getJsonKey(content);


    }

    void getJsonKey(String response) throws IOException {

        PokeModel pokeModel = new Gson().fromJson(response, PokeModel.class);
        System.out.println(pokeModel.getName() + " is the name of the pokemon object.");
        pokeModel.getPokeInfo();

    }
}
