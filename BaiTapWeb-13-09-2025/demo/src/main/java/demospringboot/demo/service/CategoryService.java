package demospringboot.demo.service;

import java.util.List;
import java.util.Optional;

import demospringboot.demo.entity.Category;


public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
    void deleteById(Long id);
    List<Category> search(String keyword);
    Optional<Category> findById(Long id);

} 