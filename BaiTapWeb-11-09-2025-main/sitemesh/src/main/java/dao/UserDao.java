package dao;

import entity.User;
import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    boolean delete(Long id);
}
