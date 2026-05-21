package com.th3.besproducts.services.impl;

import com.th3.besproducts.entities.Product;
import com.th3.besproducts.repositories.ProductRepository;
import com.th3.besproducts.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productRepository.findAll();

        return ResponseEntity.ok(products);
    }

    @Transactional
    @Override
    public ResponseEntity<Product> addProduct(Product productRequest) {
        try {
            Product product = Product.builder()
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .createdAt(Instant.now())
                    .modifiedAt(Instant.now())
                    .build();

            productRepository.save(product);

            log.info("Added product {}", product);
            return ResponseEntity.ok(productRequest);

        } catch (IllegalArgumentException e ) {
            log.error("Error adding product {}", productRequest);
            return ResponseEntity.badRequest().build();
        }
    }

    @Transactional
    @Override
    public ResponseEntity<Product> updateProduct(Product productRequest) {
        productRequest.setModifiedAt(Instant.now());

        productRepository.save(productRequest);

        return null;
    }
}
