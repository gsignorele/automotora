package uy.com.antel.apis.automotora.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import uy.com.antel.apis.automotora.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidColorException.class)
    public ResponseEntity<ErrorResponse> handleInvalidColorException(InvalidColorException e) {
    	ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        
    }

    @ExceptionHandler(NuevaException.class)
    public ResponseEntity<ErrorResponse> handleNuevaException(NuevaException e) {
    	ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        
    }

}