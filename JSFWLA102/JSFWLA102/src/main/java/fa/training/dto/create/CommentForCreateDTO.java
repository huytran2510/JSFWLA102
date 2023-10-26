package fa.training.dto.create;

import fa.training.entities.Comment;
import fa.training.entities.Post;
import fa.training.entities.User;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommentForCreateDTO {
    private String content;


    private String status;


    private LocalDate createTime;


    private String author;


    private String email;

    private User user;

    private Post post;
}
