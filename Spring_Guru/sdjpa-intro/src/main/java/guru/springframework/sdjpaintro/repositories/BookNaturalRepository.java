package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.BookNatural;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jd birla on 22-04-2023 at 12:51
 */
public interface BookNaturalRepository extends JpaRepository<BookNatural,String> {
}
