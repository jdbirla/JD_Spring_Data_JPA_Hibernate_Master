package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Book;

/**
 * Created by jd birla on 23-04-2023 at 10:18
 */
public interface BookDao {
    Book getById(Long id);

    Book findBookByTitle(String title);

    Book saveNewBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Long id);
}