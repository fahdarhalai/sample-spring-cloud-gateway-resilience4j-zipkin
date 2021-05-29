package dev.fahd.user.exception.handler;

import dev.fahd.user.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ExceptionResponse> dataNotFoundExceptionHandler(DataNotFoundException exception){
        ExceptionResponse exceptionResponse = ExceptionResponse
                .builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
