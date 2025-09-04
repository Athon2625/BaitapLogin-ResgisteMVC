package DAOImplement;

import DAO.CategoryDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import Model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoryDAOImpl implements CategoryDAO {

    private final MongoCollection<Document> collection;

    public CategoryDAOImpl(MongoDatabase database) {
        // Lấy collection Category
        this.collection = database.getCollection("Category");
    }

    @Override
    public void insert(Category category) {
        try {
            Document doc = new Document("cate_name", category.getCateName()).append("icons", category.getIcons());
            collection.insertOne(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        try {
            Document updateDoc = new Document("$set",
                    new Document("cate_name", category.getCateName()).append("icons", category.getIcons()));
            collection.updateOne(Filters.eq("_id", new ObjectId(category.getId())), updateDoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category getById(String id) {
        try {
            Document doc = collection.find(Filters.eq("_id", new ObjectId(id))).first();
            return docToCategory(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category getByName(String name) {
        try {
            Document doc = collection.find(Filters.eq("cate_name", name)).first();
            return docToCategory(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        try {
            for (Document doc : collection.find()) {
                Category category = docToCategory(doc);
                if (Objects.nonNull(category)) {
                    list.add(category);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Category> search(String keyword) {
        List<Category> list = new ArrayList<>();
        try {
            for (Document doc : collection.find(Filters.regex("cate_name", keyword))) {
                Category category = docToCategory(doc);
                if (Objects.nonNull(category)) {
                    list.add(category);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Category docToCategory(Document doc) {
        if (doc == null) return null;
        return new Category(
                doc.getObjectId("_id").toHexString(),
                doc.getString("cate_name"),
                doc.getString("icons")
        );
    }
}
