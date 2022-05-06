package dainius.app.blog.repository;

import dainius.app.blog.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
