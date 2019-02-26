package com.jwb5.eatWhat.Controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
@RequestMapping("/eat/edit/*")
public class CEdit {



    @RequestMapping("addFood")
    public void addFood(String food){

    }
}
