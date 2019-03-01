package com.jwb5.eatWhat.controller;


import com.jwb5.eatWhat.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

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
//    @RequestMapping("add")
//    public void addFood(String food){
//
//    }
}
