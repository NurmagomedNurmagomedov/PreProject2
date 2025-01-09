package webapp.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import webapp.model.User;
import org.springframework.stereotype.Service;
import webapp.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(int count) {
        return userRepository.findAll().stream()
                .limit(count)
                .collect(Collectors.toList());
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(int id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}

