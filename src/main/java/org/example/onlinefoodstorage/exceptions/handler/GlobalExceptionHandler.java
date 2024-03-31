package org.example.onlinefoodstorage.exceptions.handler;


import org.example.onlinefoodstorage.exceptions.customExceptions.AlreadyExistException;
import org.example.onlinefoodstorage.exceptions.customExceptions.BadCredentialException;
import org.example.onlinefoodstorage.exceptions.customExceptions.NotFoundException;
import org.example.onlinefoodstorage.response.ApplicationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadCredentialException.class)
    public ResponseEntity<ApplicationError> invalidExceptionHandler(BadCredentialException exception, WebRequest webRequest) {
        ApplicationError applicationError = new ApplicationError();
        applicationError.setCode("InvalidException");
        applicationError.setMessage(exception.getMessage());
        applicationError.setStatus(400);
        applicationError.setTime(LocalDateTime.now());
        return new ResponseEntity<>(applicationError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApplicationError> notFoundExceptionHandler(NotFoundException exception, WebRequest request) {
        ApplicationError applicationError = new ApplicationError();
        applicationError.setCode("NotFoundException");
        applicationError.setMessage(exception.getMessage());
        applicationError.setStatus(404);
        applicationError.setTime(LocalDateTime.now());
        return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ApplicationError> notFoundExceptionHandler(AlreadyExistException exception, WebRequest request) {
        ApplicationError applicationError = new ApplicationError();
        applicationError.setCode("AlreadyCreatedException");
        applicationError.setMessage(exception.getMessage());
        applicationError.setStatus(409);
        applicationError.setTime(LocalDateTime.now());
        return new ResponseEntity<>(applicationError, HttpStatus.CONFLICT);
    }
}
