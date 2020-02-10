package com.company;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
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
        /*JSONObject pokemon = new JSONObject(response);
        System.out.println(pokemon.get("name"));*/
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        JsonNode jsonNode = objectMapper.readTree(response);
        String name = jsonNode.get("name").asText();
        System.out.println(name + " is the name from the JSON string.");

        Pokemon pokemon = objectMapper.readValue(response, Pokemon.class);
        System.out.println(pokemon.getName() + " is the name of the pokemon object.");
        pokemon.getPokeInfo();
    }
}
