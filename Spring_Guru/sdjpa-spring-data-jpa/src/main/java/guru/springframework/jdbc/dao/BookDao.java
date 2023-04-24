package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by jd birla on 24-04-2023 at 07:25
 */
public interface BookDao {
    Book getById(Long id);

    Book findBookByTitle(String title);

    Book saveNewBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Long id);

    List<Book> findAllBooksSortByTitle(Pageable pageable);

    List<Book> findAllBooks(Pageable pageable);

    List<Book> findAllBooks(int pageSize, int offset);

    List<Book> findAllBooks();
}
