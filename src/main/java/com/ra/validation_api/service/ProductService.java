package com.ra.validation_api.service;

import com.ra.validation_api.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product save(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long id);

    List<Product> findByProductName(String productName);
}
