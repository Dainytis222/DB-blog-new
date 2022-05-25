package dainius.app.blog.controller;

import dainius.app.blog.repository.entity.Comment;
import dainius.app.blog.repository.entity.User;
import dainius.app.blog.service.CommentService;
import java.time.LocalDateTime;
import javax.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/private/posts/{id}/comments")

public class CommentPrivateController {

  private final CommentService commentService;

  public CommentPrivateController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping("/comment")
  public  String getCommentForm(@PathVariable("id") int id, Model model){

    model.addAttribute("comment", new Comment());
    model.addAttribute("postId", id);
    return "commentForm";
  }

  @PostMapping("/create")
  public String createComment(
      @PathVariable("id") int id,
      @Valid Comment comment,
      BindingResult errors,
      Model model){
    if(errors.hasErrors()){
      return "commentForm";
    }

    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    comment.setUser(user);

    comment.setDateAndTime(LocalDateTime.now());
    Comment createdComment = commentService.create(comment, id);

    model.addAttribute("comment", createdComment);
    return "redirect:/public/posts/";
  }
}

