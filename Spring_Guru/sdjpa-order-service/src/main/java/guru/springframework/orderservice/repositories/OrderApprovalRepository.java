package guru.springframework.orderservice.repositories;

import guru.springframework.orderservice.domain.OrderApproval;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jd birla on 25-04-2023 at 06:50
 */
public interface OrderApprovalRepository extends JpaRepository<OrderApproval,Long> {
}
