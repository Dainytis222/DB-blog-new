package dainius.app.blog.controller;

import dainius.app.blog.exeption.PostNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({PostNotFoundException.class})
  public String handlePostNotFoundException(Model model) {
//    model.addAttribute("postNotFound", true);
    log.error("Trying to get post that does not exist");
    return "redirect:/posts";
  }
}
