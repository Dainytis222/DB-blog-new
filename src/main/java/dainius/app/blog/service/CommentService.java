package dainius.app.blog.service;

import dainius.app.blog.exeption.CommentNotFoundException;
import dainius.app.blog.repository.CommentRepository;
import dainius.app.blog.repository.entity.Comment;
import dainius.app.blog.repository.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;
  private final PostService postService;


  public Comment create(Comment comment, int postId) {
    Post post = postService.findById(postId);
    comment.setPost(post);
    return commentRepository.save(comment);
  }

  public Comment findById(int id) {
    return commentRepository
        .findById(id)
        .orElseThrow(CommentNotFoundException::new);
  }

  public Page<Comment> findAllPageable(int pageSize, int pageNumber) {
    Pageable pageable = Pageable
        .ofSize(pageSize)
        .withPage(pageNumber);

    return commentRepository.findAll(pageable);
  }
}
