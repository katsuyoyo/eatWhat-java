package com.jwb5.eatWhat.Controller;

import com.alibaba.fastjson.JSON;
import com.jwb5.eatWhat.msg.Result;
import com.jwb5.eatWhat.redis.RedisService;
import com.jwb5.eatWhat.redis.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Tuple;

import java.util.*;

@ControllerAdvice
@RequestMapping("/eat/test/*")
public class CTest {

    @Autowired
    RedisService redisService;

    private static final String TEST = "wxz";

    @RequestMapping("list")
    @ResponseBody
    public Result listFood(){
        Set<Tuple> set = redisService.zRange(UserKey.USER_KEY,TEST,0,-1);
        Iterator<Tuple> iterator = set.iterator();
        Map<Double,String> result = new LinkedHashMap<Double, String>();
        while (iterator.hasNext()){
            Tuple tuple= iterator.next();
            result.put(tuple.getScore(),tuple.getElement());
        }
        return Result.success(result);
    }
    @RequestMapping("add")
    @ResponseBody
    public Result addFood(@RequestParam("foodId") int foodId,
                          @RequestParam("foodName") String foodName){
        redisService.zAdd(UserKey.USER_KEY,TEST,foodId,foodName);
        return Result.success();
    }
    @RequestMapping("del")
    @ResponseBody
    public Result delFood(@RequestParam("foodName") String foodName){
        redisService.zDel(UserKey.USER_KEY,TEST,foodName);
        return Result.success();
    }
    @RequestMapping("ping")
    @ResponseBody
    public String ping(){
        return "pong";
    }
}
