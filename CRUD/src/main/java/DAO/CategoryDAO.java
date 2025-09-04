package DAO;

import java.util.List;
import Model.Category;

public interface CategoryDAO {
    void insert(Category category);
    void update(Category category);
    void delete(String id);         // _id trong MongoDB là ObjectId -> dùng String để tiện convert
    Category getById(String id);    // lấy theo _id
    Category getByName(String name);
    List<Category> getAll();
    List<Category> search(String keyword);
}
