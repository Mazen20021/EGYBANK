package com.egypay.egypay.ExceptionHandler;

import com.egypay.egypay.Models.GeneralResponse;
import com.egypay.egypay.util.PreperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralException {
    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(CustomExceptions e){
        GeneralResponse generalResponse = PreperResponse.preperResponse(null,"Fail","404");
        return new ResponseEntity<>(generalResponse, HttpStatus.NOT_FOUND);
    }
}
