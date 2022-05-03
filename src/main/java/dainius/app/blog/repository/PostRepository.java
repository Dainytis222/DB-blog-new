package dainius.app.blog.repository;

import dainius.app.blog.exeption.PostNotFoundException;
import dainius.app.blog.repository.entity.Post;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PostRepository {

  private static final List<Post> posts = List.of(
      new Post(2, "Skruzdėlės",
          "Skruzdėlės (Formicidae) – plėviasparniai vabzdžiai, priklausantys smaugtapilvių Apocrita pobūriui.",
          LocalDateTime.now(), 2),
      new Post(3, "Bitės",
          "Bitės – plėviasparnių (Hymenoptera) būrio vabzdžiai, priklausantys nesistematinei sekcijai Anthophila.",
          LocalDateTime.now(), 3),
      new Post(4, "Boružės", "Boružės (Coccinellidae) – vabalų (Coleoptera) šeima.",
          LocalDateTime.now(), 4)
  );

  public List<Post> findAll() {
    return posts;
  }

//  public Post findById(int id) {
//    for (Post post : posts) {
//      if (post.getId() == id) {
//        return post;
//      }
//    }
//    return null;
//  }

  public Post findById(int id) {
    return posts.stream()
        .filter(p -> p.getId() == id)
        .findFirst()
        .orElseThrow(() -> new PostNotFoundException());
  }
}
