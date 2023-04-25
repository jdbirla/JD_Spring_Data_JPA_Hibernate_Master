package guru.springframework.orderservice.service;

import guru.springframework.orderservice.domain.Product;

/**
 * Created by jd birla on 25-04-2023 at 13:34
 */
public interface ProductService {

    Product saveProduct(Product product);

    Product updateQOH(Long id, Integer quantityOnHand);
}