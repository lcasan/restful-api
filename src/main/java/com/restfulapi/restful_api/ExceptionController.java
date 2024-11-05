package com.restfulapi.restful_api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.restfulapi.restful_api.CustomResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {
    // Handling of validation exceptions 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())
        );
        

        CustomResponse<Map<String, String>> response = new CustomResponse<>(errors, "Validation failed");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Generic exception handling
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponse<String>> handleException(Exception ex) {
        CustomResponse<String> response = new CustomResponse<>(null, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
