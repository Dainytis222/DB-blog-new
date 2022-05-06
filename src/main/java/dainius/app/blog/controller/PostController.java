package dainius.app.blog.controller;

import dainius.app.blog.exeption.PostNotFoundException;
import dainius.app.blog.repository.PostRepository;
import dainius.app.blog.repository.entity.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public String getPostList(Model model) {
    List<Post> posts = postRepository.findAll();

    model.addAttribute("posts", posts);

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

    model.addAttribute("postId", post.getId());
    model.addAttribute("postHeader", post.getHeader());
    model.addAttribute("postText", post.getText());
    model.addAttribute("postDateAndTime", post.getDateAndTime());
    model.addAttribute("postUserId", post.getUserId());

    return "postPage";
  }

}

