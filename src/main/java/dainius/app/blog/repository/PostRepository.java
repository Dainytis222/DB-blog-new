package dainius.app.blog.repository;

import dainius.app.blog.repository.entity.Post;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Integer> {

  Page<Post> findAllById(int id, Pageable pageable);

}
