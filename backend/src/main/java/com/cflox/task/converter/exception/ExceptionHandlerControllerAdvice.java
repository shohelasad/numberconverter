package com.cflox.task.converter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends RuntimeException {
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ErrorMessages> resourceAccessException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessages message = new ErrorMessages(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorMessages>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessages> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessages message = new ErrorMessages(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorMessages>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
