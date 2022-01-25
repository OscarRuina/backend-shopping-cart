package com.team98.shoppingcart.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.team98.shoppingcart.model.response.ErrorResponse;

@ControllerAdvice
public class ErrorHandler {
  @ExceptionHandler(EmailAlreadyExistException.class)
  public ResponseEntity<?> handleEmailAlreadyExist(HttpServletRequest request,
      EmailAlreadyExistException e) {
    return ResponseEntity.badRequest().body(buildResponse(e, HttpStatus.BAD_REQUEST));
  }

  @ExceptionHandler(SendEmailException.class)
  public ResponseEntity<?> handleSendEmailException(HttpServletRequest request,
      SendEmailException e) {
    return ResponseEntity.badRequest().body(buildResponse(e, HttpStatus.BAD_REQUEST));
  }

  private ErrorResponse buildResponse(Exception e, HttpStatus httpStatus) {
    return new ErrorResponse(e, httpStatus.value());
  }
}
