package com.capgemini.online_food_delivery.exception;
 

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

 

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {


    @ExceptionHandler(value = CartNotFoundException.class)
    public ResponseEntity<String> handleCartNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = ItemNotFoundException.class)
    public ResponseEntity<String> handleItemNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        return responseEntity;
    }   
    
    @ExceptionHandler(value = OrderNotFoundException.class)
    public ResponseEntity<String> handleOrderNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    
    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserAlreadyExist(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        return responseEntity;
    }

    @ExceptionHandler(value = WrongPasswordException.class)
    public ResponseEntity<String> handleWrongPassword(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        return responseEntity;
    }

    @ExceptionHandler(value = RestaurentNotFoundException.class)
    public ResponseEntity<String> handleRestaurentNotFound(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    
}
 