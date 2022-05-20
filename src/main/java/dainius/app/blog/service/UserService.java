package dainius.app.blog.service;

import dainius.app.blog.exeption.PostNotFoundException;
import dainius.app.blog.exeption.UserNotFoundException;
import dainius.app.blog.repository.UserRepository;
import dainius.app.blog.repository.entity.Post;
import dainius.app.blog.repository.entity.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User findById(int id) {
    return userRepository
        .findById(id)
        .orElseThrow(UserNotFoundException::new);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }
}
