package yamacinelli.booktracker.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class BookDto {

    private Integer id;

    @NotEmpty(message = "{name.not.empty}")
    private String name;

    @NotEmpty(message = "{author.not.empty}")
    private String author;

    @URL(message = "{url.not.valid}")
    @NotEmpty(message = "{image.url.not.empty}")
    private String imageUrl;
}
