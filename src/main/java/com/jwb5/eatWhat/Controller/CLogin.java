package com.jwb5.eatWhat.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
@RequestMapping("/eat/login/*")
public class CLogin {


    @RequestMapping("login")
    public void login(String code){

    }
}
