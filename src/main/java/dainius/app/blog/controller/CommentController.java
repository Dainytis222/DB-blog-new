package dainius.app.blog.controller;

import dainius.app.blog.repository.entity.Comment;
import dainius.app.blog.repository.entity.Post;
import dainius.app.blog.service.CommentService;
import dainius.app.blog.service.PostService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/posts/{id}/comments")
public class CommentController {

  private final CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping
  public String getCommentList(
      @RequestParam(name = "page", defaultValue = "0") int pageNumber,
      Model model) {

    Page<Comment> commentPage = commentService.findAllPageable(5, pageNumber);

    List<Comment> comments = commentPage.getContent();

    model.addAttribute("comments", comments);
    model.addAttribute("currentPage", pageNumber);
    model.addAttribute("totalPages", commentPage.getTotalPages());

    return "commentList";
  }

//  @GetMapping(path = "/posts/{id}/comments/{id}")
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
  public String createComment(Comment comment, Model model){
    comment.setDateAndTime(LocalDateTime.now());
    Comment createdComment = commentService.create(comment);

    model.addAttribute("comment", createdComment);
    return "redirect:/comments" + createdComment.getId();
  }
}

