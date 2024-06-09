package com.ra.validation_api.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DataError<T> {
    private String message;
    private T content;
    private HttpStatus httpStatus;

}
