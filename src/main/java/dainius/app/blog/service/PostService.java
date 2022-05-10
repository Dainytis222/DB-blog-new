package dainius.app.blog.service;

import dainius.app.blog.exeption.PostNotFoundException;
import dainius.app.blog.repository.PostRepository;
import dainius.app.blog.repository.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private final PostRepository postRepository;


  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public Post create(Post post) {
    return postRepository.save(post);
  }

  public Post findById(int id) {
    return postRepository
        .findById(id)
        .orElseThrow(PostNotFoundException::new);
  }

  public Page<Post> findAllPageable(int pageSize, int pageNumber) {
    Pageable pageable = Pageable
        .ofSize(pageSize)
        .withPage(pageNumber);

    return postRepository.findAll(pageable);
  }
}
