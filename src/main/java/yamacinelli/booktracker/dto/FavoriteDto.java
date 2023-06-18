package yamacinelli.booktracker.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class FavoriteDto {

    private Integer id;

    @NotNull(message = "{user.not.null}")
    private UserDto user;

    @NotEmpty(message = "{books.not.empty}")
    private List<BookDto> books;
}
