package com.company.connection;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class HandleData {

    /*ConnectionMongo connectionInstance = ConnectionMongo.INSTANCE;
    MongoCollection<Document> pokemonCollection = connectionInstance.getPokemonCollection();
    List<Document> list = new ArrayList<>();

    HandleData() {

    }

    public void printAll() {
        pokemonCollection.find().into(list);
        list.forEach(pokemon -> {
            System.out.println("\nRecord found!\nName: " + pokemon.get("name"));
        });

    }

    public boolean searchRecord(String name) {

        List<Document> pokemons = pokemonCollection.find(eq("name", name)).into(new ArrayList<>());
        pokemons.forEach(pokemon -> {
            System.out.println("Pokemon " + pokemon.get("title"));
        });
        return pokemons.contains(name);
    }*/

}