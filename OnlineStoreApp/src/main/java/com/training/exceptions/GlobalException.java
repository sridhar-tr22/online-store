package com.training.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

@ExceptionHandler(ProductException.class)
public ResponseEntity<ErrorResponse> flightError(ProductException ex)
{
ErrorResponse errorResponse=new ErrorResponse();

errorResponse.setMessage(ex.getMessage());

errorResponse.setStatus(HttpStatus.NOT_FOUND.value());


return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);

}



}