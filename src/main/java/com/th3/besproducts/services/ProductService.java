package com.th3.besproducts.services;

import com.th3.besproducts.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<List<Product>> getProducts();

    ResponseEntity<Product> addProduct(Product product);

    ResponseEntity<Product> updateProduct(Product productRequest);
}
