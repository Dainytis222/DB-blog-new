package dainius.app.blog.repository.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "text")
  @NotEmpty(message = "{post.text.notEmpty}")
  private String text;

  @Column(name = "date_time")
  private LocalDateTime dateAndTime;

  @ManyToOne(fetch = FetchType.EAGER)
  private Post post;

  @ManyToOne(fetch = FetchType.EAGER)
  private User user;

  public String getFormattedDateAndTime () {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(this.dateAndTime);
  }

}
