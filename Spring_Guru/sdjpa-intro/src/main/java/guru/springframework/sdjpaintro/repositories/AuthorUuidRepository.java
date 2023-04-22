package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.AuthorUuid;
import guru.springframework.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by jd birla on 22-04-2023 at 09:09
 */
public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {
}
