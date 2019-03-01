package com.jwb5.eatWhat.Controller;


import com.jwb5.eatWhat.msg.Result;
import com.jwb5.eatWhat.redis.RedisService;
import com.jwb5.eatWhat.redis.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@RequestMapping("/eat/edit/*")
public class CEdit {


    @Autowired
    RedisService redisService;



//    @RequestMapping("list")
//    @ResponseBody
//    public Result listFood(){
//        Result result = redisService.zRange(UserKey.USER_KEY,);
//    }
    @RequestMapping("add")
    public void addFood(String food){

    }
}
