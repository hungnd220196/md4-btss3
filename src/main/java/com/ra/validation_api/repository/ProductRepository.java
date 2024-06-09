package com.ra.validation_api.repository;

import com.ra.validation_api.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.productName like concat('%',:productName,'%') ")
    List<Product> findByProductName(String productName);

}
