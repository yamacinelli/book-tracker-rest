package yamacinelli.booktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yamacinelli.booktracker.model.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

    Favorite findFavoriteByUserId(Integer userId);

    void deleteFavoriteByUserId(Integer userId);
}
