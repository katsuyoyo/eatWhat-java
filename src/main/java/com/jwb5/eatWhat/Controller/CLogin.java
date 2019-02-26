package com.jwb5.eatWhat.Controller;

import com.jwb5.eatWhat.Util.String2ObjectUtil;
import com.jwb5.eatWhat.model.User;
import com.jwb5.eatWhat.msg.Result;
import com.jwb5.eatWhat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
@RequestMapping("/eat/login/*")
public class CLogin {

    @Autowired
    LoginService loginService;

    @RequestMapping("login")
    public Result login(String code){
        String result = loginService.code2Session(code);
        User user = String2ObjectUtil.string2Bean(result,User.class);
        //TODO
        return null;
    }
}
