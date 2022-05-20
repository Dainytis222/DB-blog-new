package dainius.app.blog.controller;

import dainius.app.blog.repository.entity.Comment;
import dainius.app.blog.service.CommentService;
import java.time.LocalDateTime;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/private/posts/{id}/comments")
public class CommentPrivateController {

  private final CommentService commentService;

  public CommentPrivateController(CommentService commentService) {
    this.commentService = commentService;
  }

//  @GetMapping(path = "public/posts/{id}/comments/{id}")
//  public String getCommentPage(
//      @PathVariable(name = "id") int id,
//      @RequestParam(name = "showComment", required = false) boolean showComment,
//      Model model
//  ) {
//
//    Comment comment = commentService.findById(id);
//
//    model.addAttribute("showComment", showComment);
//    model.addAttribute("comment", comment);
//
//    return "commentPage";
//  }

  @GetMapping("/comment")
  public  String getCommentForm(Model model){
    model.addAttribute("comment", new Comment());
    return "commentForm";
  }

  @PostMapping("/create")
  public String createComment(@Valid Comment comment, BindingResult errors, Model model){
    if(errors.hasErrors()){
      return "commentForm";
    }
    comment.setDateAndTime(LocalDateTime.now());
    Comment createdComment = commentService.create(comment);

    model.addAttribute("comment", createdComment);
    return "redirect:/comments" + createdComment.getId();
  }
}

