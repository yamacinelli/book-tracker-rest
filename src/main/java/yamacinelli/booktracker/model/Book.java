package yamacinelli.booktracker.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Lob
    @Column(nullable = false)
    private String imageUrl;
}
