package com.company.connection;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConnectionMongo {

    /*public static final ConnectionMongo INSTANCE = new ConnectionMongo() ;

    private String userName = "Lantash";
    private String passWord = "Fiskrom123";

    private MongoClientURI uri = new MongoClientURI("mongodb+srv://Lantash:Fiskrom123@splice-dxgjp.mongodb.net/test?retryWrites=true&w=majority");
    private MongoClient mongoClient = new MongoClient(uri);
    private MongoDatabase database = mongoClient.getDatabase("Javakombat");
    private MongoCollection<Document> collection = database.getCollection("pokemon");


    private MongoCollection<Document> getMovieCollection() {
        return collection;
    }
    public MongoCollection<Document> getCollection(String movieDetails) {

        return database.getCollection("movieDetails");
    }
    public void addRecord(String body){

        Document doc = Document.parse(body);
        System.out.println(doc);


        collection.insertOne(doc);
    }
*/


}
