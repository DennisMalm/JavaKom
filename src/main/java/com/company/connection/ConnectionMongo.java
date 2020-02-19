package com.company.connection;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ConnectionMongo {

    public static final ConnectionMongo INSTANCE = new ConnectionMongo();


    private String connectionUri = "localhost:27017";
    //private MongoClientURI uri = new MongoClientURI(connectionUri);
    private MongoClient mongoClient = new MongoClient(connectionUri);
    private MongoDatabase database = mongoClient.getDatabase("Javakombat");
    private MongoCollection<Document> collection = database.getCollection("pokemon");


    public MongoCollection<Document> getPokemonCollection() {
        return collection;
    }

    public void addRecord(String body) {

        Document doc = Document.parse(body);
        System.out.println(doc);
        if (searchRecord(doc.get("name").toString())) {
            System.out.println("Document already exists.");

        } else {
            System.out.println("Document added to database.");
            collection.insertOne(doc);
        }
    }

    public boolean searchRecord(String nameToCheck) {

        MongoCursor<Document> iterable = collection.find(eq("name", nameToCheck)).projection(Projections.include("name")).limit(1).iterator();
        if (iterable.hasNext()) {
            System.out.println(" ALREADY EXISTS.");
            return true;
        } else {
            System.out.println(" NOT IN DATABASE.");
            return false;
        }
    }

    /*public boolean search(String name) {

        List<Document> pokemons = collection.find(eq("name", "charmander")).into(new ArrayList<>());
        pokemons.forEach(pokemon -> {
            System.out.println("Pokemon " + pokemon.get("name"));
        });
        return pokemons.contains(name);
    }*/

}
