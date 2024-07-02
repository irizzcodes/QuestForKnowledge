package com.example.utils;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    static {
        mongoClient = MongoClients.create("mongodb://localhost:27017"); // Replace with your MongoDB URI
        database = mongoClient.getDatabase("UserAccountdb"); // Replace with your database name
    }

    public static MongoDatabase getDatabase() {
        return database;
    }
}
