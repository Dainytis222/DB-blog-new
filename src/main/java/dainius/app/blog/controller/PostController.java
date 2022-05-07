package dainius.app.blog.controller;

import dainius.app.blog.exeption.PostNotFoundException;
import dainius.app.blog.repository.PostRepository;
import dainius.app.blog.repository.entity.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/posts")
public class PostController {

  private PostRepository postRepository;

  public PostController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @GetMapping
  public String getPostList(
      @RequestParam(name = "page", defaultValue = "0") int pageNumber,
      Model model) {
    Pageable pageable = Pageable
        .ofSize(5)
        .withPage(pageNumber);

    Page<Post> postsPage = postRepository.findAll(pageable);
    List<Post> posts = postsPage.getContent();

//    List<Post> posts = postRepository.findAll();
//    List<Post> userPosts = postRepository.findPostsByUserId(4);

    model.addAttribute("posts", posts);
    model.addAttribute("currentPage", pageNumber);
    model.addAttribute("totalPages", postsPage.getTotalPages());
//    model.addAttribute("posts", userPosts);

    return "postList";
  }

  @GetMapping(path = "/{id}")
  public String getPostPage(
      @PathVariable(name = "id") int id,
      @RequestParam(name = "showComment", required = false) boolean showComment,
      Model model
  ) {

    Optional<Post> foundPost = postRepository.findById(id);

    if (foundPost.isEmpty()) {
      throw new PostNotFoundException();
    }

    Post post = foundPost.get();

    model.addAttribute("showComment", showComment);
    model.addAttribute("post", post);

    return "postPage";
  }

  @GetMapping("/post")
  public  String getPostForm(Model model){
    model.addAttribute("post", new Post());
    return "postForm";
  }

  @PostMapping("/create")
  public String createPost(Post post, Model model){
    Post createdPost = postRepository.save(post);
    model.addAttribute("post", createdPost);
    return "postPage";
  }
}

