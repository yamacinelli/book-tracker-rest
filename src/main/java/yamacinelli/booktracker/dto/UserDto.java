package yamacinelli.booktracker.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {

    private Integer id;

    @NotEmpty(message = "{email.not.empty}")
    private String email;

    @NotEmpty(message = "{password.not.empty}")
    private String password;

    @NotNull(message = "{people.not.null}")
    private PeopleDto people;
}
