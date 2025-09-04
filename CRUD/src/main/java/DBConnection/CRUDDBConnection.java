package DBConnection;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class CRUDDBConnection {
    private final String connectionString = "mongo://localhost:27017";
    private final String DBName = "ServletCRUDMVC";

    private MongoClient mongoClient;

    public CRUDDBConnection(){
        mongoClient = MongoClients.create(connectionString);
    }

    //Lấy DB
    public MongoDatabase getDatabase() {
        return mongoClient.getDatabase(DBName);
    }
    //Lấy collection
    public MongoCollection<Document> getCollection(String collectionName) {
        return getDatabase().getCollection(collectionName);
    }
    public void close() {
        if (mongoClient != null)
        mongoClient.close();
    }
}
