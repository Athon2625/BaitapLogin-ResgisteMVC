package ServiceImplement;

import DAO.CategoryDAO;
import DAOImplement.CategoryDAOImpl;
import Model.Category;
import Service.CategoryService;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.io.File;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDao;

    // Constructor inject từ ngoài vào (nếu bạn muốn chủ động quản lý database)
    public CategoryServiceImpl(MongoDatabase database) {
        this.categoryDao = new CategoryDAOImpl(database);
    }

    // Constructor rỗng - tự kết nối MongoDB (dùng cho Controller)
    public CategoryServiceImpl() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("ServletCRUDMVC");
        this.categoryDao = new CategoryDAOImpl(database);
    }

    @Override
    public boolean insert(Category category) {
        try {
            categoryDao.insert(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Category newCategory) {
        try {
            Category oldCategory = categoryDao.getById(newCategory.getId());
            if (oldCategory == null) {
                return false; // Không tìm thấy category
            }

            oldCategory.setCateName(newCategory.getCateName());

            if (newCategory.getIcons() != null) {
                // Xóa icon cũ nếu tồn tại
                String fileName = oldCategory.getIcons();
                if (fileName != null) {
                    final String dir = "E:\\upload";
                    File file = new File(dir + "/category/" + fileName);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                oldCategory.setIcons(newCategory.getIcons());
            }

            categoryDao.update(oldCategory);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            categoryDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Category getById(String id) {
        return categoryDao.getById(id);
    }

    @Override
    public Category getByName(String name) {
        return categoryDao.getByName(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public List<Category> search(String keyword) {
        return categoryDao.search(keyword);
    }
}
