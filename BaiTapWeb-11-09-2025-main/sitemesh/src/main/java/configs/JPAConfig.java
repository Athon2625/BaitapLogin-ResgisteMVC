package configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig {

    private static final EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory("dataSource");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    // Optional: close factory khi ứng dụng tắt
    public static void closeFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}
