package dainius.app.blog.controller;

import dainius.app.blog.exeption.PostNotFoundException;
import dainius.app.blog.repository.entity.Post;
import dainius.app.blog.service.PostService;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/posts")
public class PostController {

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public String getPostList(
      @RequestParam(name = "page", defaultValue = "0") int pageNumber,
      Model model) {

    Page<Post> postPage = postService.findAllPageable(5, pageNumber);

    List<Post> posts = postPage.getContent();

    model.addAttribute("posts", posts);
    model.addAttribute("currentPage", pageNumber);
    model.addAttribute("totalPages", postPage.getTotalPages());

    return "postList";
  }

  @GetMapping(path = "/{id}")
  public String getPostPage(
      @PathVariable(name = "id") int id,
      Model model
  ) {

    Post post = postService.findById(id);

    model.addAttribute("post", post);

    return "postPage";
  }

  @GetMapping("/{id}/edit")
  public String getPostEditForm(
      @PathVariable(name = "id") int id,
      Model model
  ) {

    Post post = postService.findById(id);
    model.addAttribute("post", post);
    return "postEditForm";
  }

  @PostMapping("/edit/{id}")
  public String editPost(@PathVariable(name = "id") int id, @Valid Post post, BindingResult errors, Model model){
    if (errors.hasErrors()) {
      return "postEditForm";
    }
    post.setDateAndTime(LocalDateTime.now());
    Post editedPost = postService.edit(post);

    model.addAttribute("edit", editedPost);
    return "redirect:/posts/" + editedPost.getId();
  }

  @GetMapping("/post")
  public String getPostForm(Model model) {
    return "postForm";
  }

  @PostMapping("/create")
  public String createPost(@Valid Post post, BindingResult errors, Model model) {
    if (errors.hasErrors()) {
      return "postForm";
    }

    post.setDateAndTime(LocalDateTime.now());
    Post createdPost = postService.create(post);

    model.addAttribute("post", createdPost);
    return "redirect:/posts/" + createdPost.getId();
  }

  @ModelAttribute("post")
  public Post populateEmptyPost() {
    return new Post();
  }
}

