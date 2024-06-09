package com.ra.validation_api.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequestDTO {
    @NotBlank(message = "ProductName is empty")
    private String productName;
    @NotBlank(message = "Producer is empty")
    private String producer;
    @NotNull(message = "yearMaking is empty")
    private Integer yearMaking;
    @NotNull(message = "expireDate is empty")
    private Integer expiryDate;
    @Min(value = 0, message = "Price must be equal or greater than 0")
    @NotNull(message = "Price is mandatory")
    private Double price;
}
