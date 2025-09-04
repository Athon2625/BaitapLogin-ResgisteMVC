package Service;

import Model.Category;
import java.util.List;

public interface CategoryService {
    // Thêm mới category
    boolean insert(Category category);

    // Cập nhật category theo id
    boolean update(Category category);

    // Xóa category theo id
    boolean delete(String id);

    // Lấy category theo id
    Category getById(String id);

    // Lấy category theo tên
    Category getByName(String name);

    // Lấy tất cả categories
    List<Category> getAll();

    // Tìm kiếm theo từ khóa
    List<Category> search(String keyword);
}
