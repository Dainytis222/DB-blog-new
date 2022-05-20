package dainius.app.blog.controller;

import dainius.app.blog.repository.entity.Comment;
import dainius.app.blog.service.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("public/posts/{id}/comments")
@RequiredArgsConstructor
public class CommentPublicController {

  private final CommentService commentService;

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
}
