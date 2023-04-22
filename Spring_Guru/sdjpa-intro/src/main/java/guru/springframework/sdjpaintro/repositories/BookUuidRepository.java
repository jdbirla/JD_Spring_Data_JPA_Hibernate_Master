package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.domain.BookUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by jd birla on 22-04-2023 at 09:15
 */
public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {
}
