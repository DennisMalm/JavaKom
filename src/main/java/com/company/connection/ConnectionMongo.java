package com.company.connection;

import com.company.model.PokemonJson;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

@Data
@NoArgsConstructor
public class ConnectionMongo {

    public static final ConnectionMongo INSTANCE = new ConnectionMongo();


    private String connectionUri = "localhost:27017";
    //private MongoClientURI uri = new MongoClientURI(connectionUri);
    private MongoClient mongoClient = new MongoClient(connectionUri);
    private MongoDatabase database = mongoClient.getDatabase("Javakombat");
    private MongoCollection<Document> collection = database.getCollection("pokemon");

    public boolean addRecord(String body) {

        collection.insertOne(Document.parse(body));
        System.out.println("Record added to DB: " + body);
        return true;
    }

    public boolean searchRecord(String checkName) {
        MongoCursor<Document> iterable = collection.find(eq("name", checkName))
                .projection(Projections.include("name"))
                .limit(1).iterator();
        if (iterable.hasNext()) {
            System.out.println(checkName + " already exists in database.");
            return true;
        } else {
            System.out.println(checkName + " not in database");
            return false;
        }
    }

    public PokemonJson getPokemon(String name) {
        ArrayList<Document> list = new ArrayList<>();
        collection.find(eq("name", name)).into(list);
        System.out.println("Pokemon loaded from SB: " + list.get(0));
        return new Gson().fromJson((list.get(0).toJson()), PokemonJson.class);
    }

}
