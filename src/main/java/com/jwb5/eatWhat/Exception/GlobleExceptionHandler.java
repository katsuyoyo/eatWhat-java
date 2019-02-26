package com.jwb5.eatWhat.Exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public void handleException(Exception e){

    }



}
