package yamacinelli.booktracker.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private People people;
}