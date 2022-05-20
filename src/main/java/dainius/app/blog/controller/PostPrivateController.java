package dainius.app.blog.controller;

import dainius.app.blog.repository.entity.Post;
import dainius.app.blog.service.PostService;
import java.time.LocalDateTime;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private/posts")
@RequiredArgsConstructor
public class PostPrivateController {

  private final PostService postService;

  @GetMapping("/post")
  public String getPostForm(Model model) {
    return "postForm";
  }

  @PostMapping("/create")
  public String createPost(
      @Valid Post post,
      BindingResult errors,
      Model model) {
    if (errors.hasErrors()) {
      return "postForm";
    }

    post.setDateAndTime(LocalDateTime.now());
    Post createdPost = postService.create(post);

    model.addAttribute("post", createdPost);
    return "redirect:/public/posts/" + createdPost.getId();
  }

  @ModelAttribute("post")
  public Post populateEmptyPost() {
    return new Post();
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
  public String editPost(
      @PathVariable(name = "id") int id,
      @Valid Post post,
      BindingResult errors,
      Model model) {
    if (errors.hasErrors()) {
      return "postEditForm";
    }
    post.setDateAndTime(LocalDateTime.now());
    Post editedPost = postService.edit(post);

    model.addAttribute("edit", editedPost);
    return "redirect:/public/posts/" + editedPost.getId();
  }

  @GetMapping("/delete/{id}")
  public String deletePost(
      @PathVariable(name = "id") int id) {

    postService.delete(id);
    return "redirect:/public/posts";
  }

}
