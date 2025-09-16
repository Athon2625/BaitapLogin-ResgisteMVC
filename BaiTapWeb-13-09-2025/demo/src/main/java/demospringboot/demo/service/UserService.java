package demospringboot.demo.service;

import java.util.List;
import demospringboot.demo.entity.User; 

    
public interface UserService {
    List<User> findAll();
    User save(User user);
    void deleteById(Long id);
    List<User> search(String keyword);
    User findById(Long id);
} 
