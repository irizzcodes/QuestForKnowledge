package com.example.repository;

import com.example.model.User;
import com.example.utils.MongoDBUtil;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.mindrot.jbcrypt.BCrypt;

public class UserRepository {
    private MongoCollection<Document> usersCollection;

    public UserRepository() {
        usersCollection = MongoDBUtil.getDatabase().getCollection("users");
    }

    public boolean registerUser(User user) {
        if (getUserByUsername(user.getUsername()) != null) {
            return false; // User already exists
        }

        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        Document doc = new Document("username", user.getUsername())
                .append("password", hashedPassword)
                .append("email", user.getEmail());

        usersCollection.insertOne(doc);
        return true;
    }

    public User getUserByUsername(String username) {
        Document doc = usersCollection.find(new Document("username", username)).first();
        if (doc != null) {
            return new User(doc.getString("username"), doc.getString("password"), doc.getString("email"));
        }
        return null;
    }

    public boolean loginUser(String username, String password) {
        User user = getUserByUsername(username);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean validateUser(String username, String email, String password) {
        User user = getUserByUsername(username);
        if (user != null && user.getEmail().equals(email) && BCrypt.checkpw(password, user.getPassword())) {
            return true;
        }
        return false;
    }
}