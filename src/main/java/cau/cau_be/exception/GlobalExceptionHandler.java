package cau.cau_be.exception;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<ExceptionResponse> handleNoSuchElementException(
      NoSuchElementException e) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }
}
