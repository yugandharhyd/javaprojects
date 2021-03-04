package com.tonline.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
* <h1>GlobalExceptionHandler is used to handle common exceptions
* across all API controllers!</h1>
* 
* @author  Yugandhara Reddy Kuraakula 
* @version 1.0
* @since   2021-03-02
*/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
      ErrorMessage message = new ErrorMessage(
          HttpStatus.NOT_FOUND.value(),
          new Date(),
          exception.getMessage(),
          webRequest.getDescription(false));
      
      return message;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception exception, WebRequest webRequest) {
      ErrorMessage message = new ErrorMessage(
          HttpStatus.INTERNAL_SERVER_ERROR.value(),
          new Date(),
          exception.getMessage(),
          webRequest.getDescription(false));
      
      return message;
    }

}
