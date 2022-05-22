package dainius.app.blog.service;

import dainius.app.blog.exeption.UserNotFoundException;
import dainius.app.blog.repository.UserRepository;
import dainius.app.blog.repository.entity.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  public User findById(int id) {
    return userRepository
        .findById(id)
        .orElseThrow(UserNotFoundException::new);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findUserByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " was not found"));
  }
}
