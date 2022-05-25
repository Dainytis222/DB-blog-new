package dainius.app.blog.repository.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Bean;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column (name = "header")
  @NotEmpty(message = "{post.text.notEmpty}")
  private String header;

  @Column (name = "text", length = 2000)
  @NotEmpty
  private String text;

  @Column (name = "date_time")
  private LocalDateTime dateAndTime;

  @ManyToOne(fetch = FetchType.EAGER)
  private User user;

  @Fetch(FetchMode.SUBSELECT)
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
  private List<Comment> comments = new ArrayList<>();

  public String getFormattedDateAndTime () {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(this.dateAndTime);
  }
}

