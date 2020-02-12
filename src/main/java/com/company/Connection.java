package com.company;



import com.company.entity.PokemonJson;
import com.company.entity.PokemonMovesJson;
import com.google.gson.Gson;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Data
@NoArgsConstructor
public class Connection {

    private String jsonResponse;
    private String urlPokemon = "https://pokeapi.co/api/v2/pokemon/";
    private String urlMove = "https://pokeapi.co/api/v2/";

    public PokemonJson getPokemon(String endPoint) throws IOException, InterruptedException {

        PokemonJson pokemon = new Gson().fromJson(conn(urlPokemon + endPoint), PokemonJson.class);

        return pokemon;
    }

    public PokemonMovesJson getMove(String endPoint) throws IOException, InterruptedException {
        PokemonMovesJson move = new Gson().fromJson(conn(endPoint), PokemonMovesJson.class);
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
