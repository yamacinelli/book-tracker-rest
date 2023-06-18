package yamacinelli.booktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yamacinelli.booktracker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
