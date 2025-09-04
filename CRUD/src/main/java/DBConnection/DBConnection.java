package DBConnection;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DBConnection {
    // Kết nối đến MongoDB server local (Compass cũng dùng URI này)
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DB_NAME = "ltweb";  // Tên database bạn tạo trong MongoDB Compass
    private static MongoClient mongoClient;

    public static MongoDatabase getConnection() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        return mongoClient.getDatabase(DB_NAME);
    }

    public static void main(String[] args) {
        try {
            MongoDatabase db = getConnection();
            System.out.println("Kết nối thành công đến MongoDB database: " + db.getName());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Kết nối thất bại!");
        }
    }
}
