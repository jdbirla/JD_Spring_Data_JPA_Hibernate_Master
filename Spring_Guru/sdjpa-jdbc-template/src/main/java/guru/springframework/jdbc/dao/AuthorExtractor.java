package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Author;
import guru.springframework.jdbc.domain.AuthorMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jd birla on 23-04-2023 at 10:51
 */
public class AuthorExtractor implements ResultSetExtractor<Author> {
    @Override
    public Author extractData(ResultSet rs) throws SQLException, DataAccessException {
        rs.next();

        return new AuthorMapper().mapRow(rs, 0);
    }
}