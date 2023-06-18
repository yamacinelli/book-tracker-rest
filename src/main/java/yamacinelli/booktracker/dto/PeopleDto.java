package yamacinelli.booktracker.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PeopleDto {

    private Integer id;

    @NotEmpty(message = "{name.not.empty}")
    private String name;

    @NotEmpty(message = "{last.name.not.empty}")
    private String lastName;
}
