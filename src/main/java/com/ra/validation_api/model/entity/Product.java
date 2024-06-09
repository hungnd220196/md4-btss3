package com.ra.validation_api.model.entity;

import com.ra.validation_api.validator.ProductNameExist;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100, unique = true)
    @NotBlank(message = "ProductName is empty")
    @ProductNameExist
    private String productName;
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Producer is empty")
    private String producer;
    @Column(nullable = false)
    @NotNull(message = "yearMaking is empty")
    private Integer yearMaking;
    @Column(nullable = false)
    @NotNull(message = "expireDate is empty")
    private Integer expiryDate;
    @Min(value = 0, message = "Price must be equal or greater than 0")
    @NotNull(message = "Price is empty")
    @Column(nullable = false)
    private Double price;
}
