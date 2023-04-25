package guru.springframework.orderservice.repositories;

import guru.springframework.orderservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by jd birla on 24-04-2023 at 18:51
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerByCustomerNameIgnoreCase(String customerName);

}