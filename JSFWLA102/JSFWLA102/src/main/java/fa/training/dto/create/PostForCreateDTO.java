package fa.training.dto.create;

import fa.training.entities.User;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostForCreateDTO {

    private String title;


    private String content;


    private String tags;


    private String status;


    private LocalDate create_time;


    private LocalDate update_time;

    private User user;

}
