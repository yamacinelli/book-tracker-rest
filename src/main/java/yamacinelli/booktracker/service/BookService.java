package yamacinelli.booktracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yamacinelli.booktracker.dto.BookDto;
import yamacinelli.booktracker.model.Book;
import yamacinelli.booktracker.repository.BookRepository;
import yamacinelli.booktracker.utils.ParseUtils;

import java.util.List;

@Service
public class BookService implements GenericService<BookDto> {
    
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto save(BookDto dto) {
        return ParseUtils.parse(
                bookRepository.saveAndFlush(ParseUtils.parse(dto, Book.class)),
                BookDto.class);
    }

    @Override
    public List<BookDto> saveAll(List<BookDto> dtos) {
        return ParseUtils.parse(
                bookRepository.saveAllAndFlush(ParseUtils.parse(dtos, Book.class)),
                BookDto.class);
    }

    @Override
    public BookDto findById(Integer id) {
        return ParseUtils.parse(
                bookRepository.findById(id),
                BookDto.class);
    }

    @Override
    public List<BookDto> findAll() {
        return ParseUtils.parse(
                bookRepository.findAll(),
                BookDto.class);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto update(BookDto dto) {
        return ParseUtils.parse(
                bookRepository.saveAndFlush(ParseUtils.parse(dto, Book.class)),
                BookDto.class);
    }
}
