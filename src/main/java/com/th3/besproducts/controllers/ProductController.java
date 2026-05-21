package com.th3.besproducts.controllers;

import com.th3.besproducts.entities.Product;
import com.th3.besproducts.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    @GetMapping("/v1/products")
    ResponseEntity<List<Product>> getProducts(){
        log.info("starting endpoint: GET /v1/products");

        return productService.getProducts();
    }

    @PostMapping("/v1/product")
    ResponseEntity<Product> addProduct(@RequestBody Product product){
        log.info("starting endpoint: POST /v1/product");

        return productService.addProduct(product);
    }

    @PatchMapping("/v1/product")
    ResponseEntity<Product> updateProduct(@RequestBody final Product product){
        log.info("starting endpoint: PATCH /v1/product");

        return productService.updateProduct(product);
    }

}
