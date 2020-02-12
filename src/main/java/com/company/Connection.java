package com.company;



import com.company.pokemon.PokemonJson;
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

        PokemonJson pokemon =
        conn(urlPokemon + endPoint);

        return pokemon;
    }

    public void getMove() {

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
