package service;

import entity.User;
import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    User save(User user);
    boolean delete(Long id);
}
