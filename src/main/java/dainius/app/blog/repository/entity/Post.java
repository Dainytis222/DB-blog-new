package dainius.app.blog.repository.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Post {

  private final int id;
  private final String header;
  private final String text;
  private final LocalDateTime dateAndTime;
  private final int userId;

}

