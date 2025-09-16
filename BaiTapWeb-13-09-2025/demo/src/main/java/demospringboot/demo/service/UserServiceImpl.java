package demospringboot.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import demospringboot.demo.repository.UserRepository;
import demospringboot.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> search(String keyword) {
        return userRepository.findByUsername(keyword);
    }
    @Override
    public User findById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).orElse(null);
    }

}
