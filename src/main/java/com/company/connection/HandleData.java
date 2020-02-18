package com.company.connection;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class HandleData {

    ConnectionMongo connectionInstance = ConnectionMongo.INSTANCE;
    MongoCollection<Document> movieCollection = connectionInstance.getCollection("movieDetails");
    List<Document> list = new ArrayList<>();

    HandleData() {

    }

    public void printAll() {
        movieCollection.find().into(list);
        list.forEach(movie -> {
            System.out.println("\nRecord found!\nTitle: " + movie.get("title") + "\nRelease year: " + movie.get("year"));
        });

    }

    public void searchRecord() {

        List<Document> actors = movieCollection.find(eq("actors","Will Smith")).into(new ArrayList<>());
        actors.forEach(actor -> {
            System.out.println("Title: " + actor.get("title") + " Cast: " + actor.get("actors"));
        });
    }


}