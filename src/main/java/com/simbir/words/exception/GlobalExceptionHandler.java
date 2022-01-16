package com.simbir.words.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(IncorrectUrlException exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());
        log.warn("Bad url for request", exception);
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}