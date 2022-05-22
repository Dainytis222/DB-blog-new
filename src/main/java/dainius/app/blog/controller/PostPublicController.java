package dainius.app.blog.controller;

import dainius.app.blog.repository.entity.Post;
import dainius.app.blog.repository.entity.User;
import dainius.app.blog.service.PostService;
import dainius.app.blog.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("public/posts")
@RequiredArgsConstructor
public class PostPublicController {

  private final PostService postService;
  private final UserService userService;

  @GetMapping
  public String getPostList(
      @RequestParam(name = "page", defaultValue = "0") int pageNumber,
      Model model) {

    Page<Post> postPage = postService.findAllPageable(5, pageNumber);

    List<Post> posts = postPage.getContent();
    List<User> users = userService.findAll();

    Map<Integer, String> usersMap = new HashMap<>();
    for (User user : users) {
      usersMap.put(user.getId(), user.getName());
    }

    model.addAttribute("posts", posts);
    model.addAttribute("currentPage", pageNumber);
    model.addAttribute("totalPages", postPage.getTotalPages());
    model.addAttribute("usersMap", usersMap);

    return "postList";
  }

  @GetMapping(path = "/{id}")
  public String getPostPage(
      @PathVariable(name = "id") int id,
      Model model
  ) {

    Post post = postService.findById(id);
    User user = post.getUser();


    model.addAttribute("post", post);
    model.addAttribute("user", user);

    return "postPage";
  }
}
