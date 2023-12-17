package com.bookstore.amber.ExceptionHandeler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> res=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String field=((FieldError)error).getField();
            String message=error.getDefaultMessage();
            res.put(field, message);
        });
        return new ResponseEntity<Map<String,String>>(res,HttpStatus.BAD_REQUEST);
        
    }
    
}
