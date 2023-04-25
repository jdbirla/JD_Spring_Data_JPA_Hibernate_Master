package guru.springframework.orderservice.repositories;

import guru.springframework.orderservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by jd birla on 24-04-2023 at 13:42
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByDescription(String description);

}
