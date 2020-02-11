package com.company;


import com.google.gson.Gson;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class PokeApiConn {

    private String responseJson;
    private String requestString = "https://pokeapi.co/api/v2/pokemon/";

    public PokeApiConn(String endPoint) throws IOException, InterruptedException {

        requestString += endPoint;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestString))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        this.responseJson = response.body();
    }

    public void printResponseBody() {
        System.out.println(responseJson);
    }

    public PokeModel jsonToJava() throws IOException {

        PokeModel pokeModel = null;
        try {
            pokeModel = new Gson().fromJson(responseJson, PokeModel.class);
        } catch (IllegalStateException ISE) {
            System.out.println("That pokemon does not exist!");
        }
        assert pokeModel != null;
        System.out.println(pokeModel.getName() + " is the name of the pokemon object.");
        pokeModel.getPokeInfo();
        return pokeModel;
        
    }
}
