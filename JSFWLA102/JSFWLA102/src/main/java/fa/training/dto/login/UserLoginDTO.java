package fa.training.dto.login;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserLoginDTO {

    private String username;

    private String password;

}
