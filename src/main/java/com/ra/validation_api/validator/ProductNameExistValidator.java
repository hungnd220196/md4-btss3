package com.ra.validation_api.validator;

import com.ra.validation_api.repository.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductNameExistValidator implements ConstraintValidator<ProductNameExist, String> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }
        return productRepository.findByProductName(s) == null;
    }
}
