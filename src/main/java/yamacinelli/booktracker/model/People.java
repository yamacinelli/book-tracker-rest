package yamacinelli.booktracker.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;
}
