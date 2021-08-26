package com.consultorio.management.interceptor;

import com.consultorio.management.error.ApiError;
import com.consultorio.management.exception.MedicNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class RestMedicInterceptor {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MedicNotFoundException.class)
    public ApiError handleMedicNotFound(MedicNotFoundException e) {
        return getApiError("Not Found", e);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ApiError handleMedicNotFound(EmptyResultDataAccessException e) {
        return getApiError("Invalid parameter", e);
    }



    private ApiError getApiError(String title, Exception e) {
        return ApiError.builder()
                .title(title)
                .message(e.getMessage())
                .timeStamp(ZonedDateTime.now())
                .build();
    }
}
