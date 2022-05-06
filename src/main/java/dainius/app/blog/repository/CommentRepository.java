package dainius.app.blog.repository;

import dainius.app.blog.repository.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
