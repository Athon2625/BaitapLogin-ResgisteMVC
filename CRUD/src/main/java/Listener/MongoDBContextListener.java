package Listener;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MongoDBContextListener implements ServletContextListener {
    private MongoClient mongoClient;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // Tạo client kết nối MongoDB (localhost:27017)
            mongoClient = MongoClients.create("mongodb://localhost:27017");

            // Lấy database (nếu chưa có thì Mongo sẽ tạo khi cần)
            MongoDatabase database = mongoClient.getDatabase("ServletCRUDMVC");

            // Đặt database vào ServletContext để servlet khác lấy ra dùng
            sce.getServletContext().setAttribute("MONGO_DB", database);

            System.out.println("MongoDB connected and set to context.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("MongoDB connection failed.", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("MongoDB connection closed.");
        }
    }
}
