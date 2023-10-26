package fa.training.dto.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientRegisterDTO {

    @Size(min = 6, max = 20, message = "Length of username should be from 6 to 20")
    @NotEmpty(message = "Please enter username")
    private String username;

    @Size(min = 6, max = 20, message = "Length of password should be from 6 to 20")
    @NotEmpty(message = "Please enter password")
    private String password;

    @Size(min = 6, max = 20, message = "Length of password confirm should be from 6 to 20")
    @NotEmpty(message = "Please enter password")
    private String passwordConfirm;

    private String salt;

    @Email(message = "{user.email.invalid}")
    @NotEmpty(message = "Please enter email")
    private String email;

    private String profile;
}
