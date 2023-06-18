package yamacinelli.booktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yamacinelli.booktracker.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
