package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Author;

/**
 * Created by jd birla on 23-04-2023 at 07:37
 */
public interface AuthorDao {

    Author getById(Long id);

    Author findAuthorByName(String firstName, String lastName);

    Author saveNewAuthor(Author author);


    Author updateAuthor(Author saved);

    public void deleteAuthorById(Long id);
}