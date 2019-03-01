package com.jwb5.eatWhat.controller;

import com.jwb5.eatWhat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
@RequestMapping("/eat/login/*")
public class CLogin {

    @Autowired
    LoginService loginService;


}
