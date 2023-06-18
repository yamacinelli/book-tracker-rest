package yamacinelli.booktracker.service;

import java.util.List;

public interface GenericService<T> {

    T save(T dto);

    List<T> saveAll(List<T> dtos);

    T findById(Integer id);

    List<T> findAll();

    void delete(Integer id);

    T update(T dto);
}
