package com.ra.validation_api.controller;

import com.ra.validation_api.model.dto.response.DataResponse;
import com.ra.validation_api.model.entity.Product;
import com.ra.validation_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Product>>> getAllProducts() {
        return new ResponseEntity<>(new DataResponse<>(productService.getAllProducts(), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<DataResponse<Product>> getProductById(@PathVariable Long productId) {
        return new ResponseEntity<>(new DataResponse<>(productService.getProductById(productId), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Product>> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(new DataResponse<>(productService.save(product), HttpStatus.OK), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DataResponse<Product>> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(new DataResponse<>(productService.updateProduct(product), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<DataResponse<List<Product>>> findByProductName(@PathVariable String productName) {
        return new ResponseEntity<>(new DataResponse<>(productService.findByProductName(productName), HttpStatus.OK), HttpStatus.OK);
    }
}
