package dainius.app.blog.repository.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column (name = "text")
  private String text;

  @Column (name = "date_time")
  private LocalDateTime dateAndTime;

  @Column (name = "post_id")
  private int postId;

  @Column (name = "user_id")
  private int userId;

}