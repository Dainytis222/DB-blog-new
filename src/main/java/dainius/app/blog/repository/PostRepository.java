package dainius.app.blog.repository;

import dainius.app.blog.repository.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
