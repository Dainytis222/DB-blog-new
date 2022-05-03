package dainius.app.blog.controller;

import dainius.app.blog.repository.PostRepository;
import dainius.app.blog.repository.entity.Post;
import java.util.List;
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

    Post foundPost = postRepository.findById(id);

    model.addAttribute("showComment", showComment);

    model.addAttribute("postId", foundPost.getId());
    model.addAttribute("postHeader", foundPost.getHeader());
    model.addAttribute("postText", foundPost.getText());
    model.addAttribute("postDateAndTime", foundPost.getDateAndTime());
    model.addAttribute("postUserId", foundPost.getUserId());


    return "postPage";
  }

}

