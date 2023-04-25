package guru.springframework.orderservice.service;

import guru.springframework.orderservice.domain.Product;
import guru.springframework.orderservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jd birla on 25-04-2023 at 13:35
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    @Transactional
    public Product updateQOH(Long id, Integer quantityOnHand) {
        Product product = productRepository.findById(id)
                .orElseThrow();

        product.setQuantityOnHand(quantityOnHand);

        return productRepository.saveAndFlush(product);
    }
}