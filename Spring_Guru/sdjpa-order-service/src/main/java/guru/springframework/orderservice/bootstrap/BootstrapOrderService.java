package guru.springframework.orderservice.bootstrap;

import guru.springframework.orderservice.domain.OrderHeader;
import guru.springframework.orderservice.repositories.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jd birla on 25-04-2023 at 12:15
 */
@Service
public class BootstrapOrderService{
    @Autowired
    OrderHeaderRepository orderHeaderRepository;


    @Transactional
    public void readOrderData() {
        OrderHeader orderHeader = orderHeaderRepository.findById(27L).get();

        orderHeader.getOrderLines().forEach(ol -> {
            System.out.println(ol.getProduct().getDescription());

            ol.getProduct().getCategories().forEach(cat -> {
                System.out.println(cat.getDescription());
            });
        });
    }

}
