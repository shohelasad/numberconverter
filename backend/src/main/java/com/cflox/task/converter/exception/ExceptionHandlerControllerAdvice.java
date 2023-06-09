package com.cflox.task.converter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends RuntimeException {
    @ExceptionHandler({UnsupportedOperationException.class})
    public ResponseEntity<ErrorMessages> methodNotAllowedException(UnsupportedOperationException ex, WebRequest request) {
        ErrorMessages message = new ErrorMessages(
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorMessages>(message, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorMessages> badRequestExceptions(BadRequestException ex, WebRequest request) {
        ErrorMessages message = new ErrorMessages(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorMessages>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorMessages message = new ErrorMessages(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorMessages>(message, HttpStatus.BAD_REQUEST);
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
