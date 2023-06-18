package yamacinelli.booktracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yamacinelli.booktracker.dto.BookDto;
import yamacinelli.booktracker.dto.FavoriteDto;
import yamacinelli.booktracker.model.Book;
import yamacinelli.booktracker.model.Favorite;
import yamacinelli.booktracker.model.User;
import yamacinelli.booktracker.repository.FavoriteRepository;
import yamacinelli.booktracker.utils.ParseUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteService {
    
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private BookService bookService;

    public FavoriteDto save(FavoriteDto dto) {
        return ParseUtils.parse(
                favoriteRepository.saveAndFlush(ParseUtils.parse(dto, Favorite.class)),
                FavoriteDto.class);
    }

    public FavoriteDto findById(Integer id) {
        return ParseUtils.parse(
                favoriteRepository.findFavoriteByUserId(id),
                FavoriteDto.class);
    }

    public List<FavoriteDto> findAll() {
        return ParseUtils.parse(
                favoriteRepository.findAll(),
                FavoriteDto.class);
    }

    public void delete(Integer id) {
        favoriteRepository.deleteFavoriteByUserId(id);
    }

    public FavoriteDto update(FavoriteDto dto) {
        return ParseUtils.parse(
                favoriteRepository.saveAndFlush(ParseUtils.parse(dto, Favorite.class)),
                FavoriteDto.class);
    }

    public FavoriteDto existFavorite(Integer userId, BookDto dto) {
        Favorite favorite = favoriteRepository.findFavoriteByUserId(userId);

        if (favorite.getId() != null) {
            Book book = ParseUtils.parse(bookService.save(dto), Book.class);
            favorite.getBook().add(book);

            return ParseUtils.parse(
                    update(ParseUtils.parse(favorite, FavoriteDto.class)),
                    FavoriteDto.class);
        } else {
            User user = new User();
            user.setId(userId);

            Book book = ParseUtils.parse(
                    bookService.save(dto),
                    Book.class);

            List<Book> books = new ArrayList<>();
            books.add(book);

            favorite.setUser(user);
            favorite.setBook(books);

            return save(ParseUtils.parse(favorite, FavoriteDto.class));
        }
    }
}
