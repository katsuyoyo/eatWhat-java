package com.jwb5.eatWhat.controller;

import com.jwb5.eatWhat.msg.Result;
import com.jwb5.eatWhat.redis.RedisService;
import com.jwb5.eatWhat.redis.UserKey;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Tuple;

import java.util.*;

@ControllerAdvice
@RequestMapping("/eat/test/*")
@Api(value = "测试用类，添加、删除、查询功能")
public class CTest {

    @Autowired
    RedisService redisService;

    private static final String TEST = "wxz";

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户所有菜名",notes = "暂未做用户匹配")
    public Result listFood(){
        Set<Tuple> set = redisService.zRange(UserKey.USER_KEY,TEST,0,-1);
        Iterator<Tuple> iterator = set.iterator();
        Map<Double,String> result = new LinkedHashMap<Double, String>();
        while (iterator.hasNext()){
            Tuple tuple= iterator.next();
            result.put(tuple.getScore(),tuple.getElement());
        }
        List<Map<String, String>> jsonresult = new ArrayList<Map<String, String>>();
        for(Double key : result.keySet()){
            Map<String, String> map = new HashMap<>();
            map.put("foodId",String.valueOf(key));
            map.put("foodName",result.get(key));
            jsonresult.add(map);
        }
        return Result.success(jsonresult);
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "增加新菜名")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "foodId",value = "菜ID",required = true,dataType = "Double"),
            @ApiImplicitParam(paramType = "query",name = "foodName",value = "菜名",required = true,dataType = "String")
    })
    public Result addFood(@RequestParam("foodId") double foodId,
                          @RequestParam("foodName") String foodName){
        redisService.zAdd(UserKey.USER_KEY,TEST,foodId,foodName);
        return Result.success();
    }
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除菜名")
    @ApiImplicitParam(paramType = "query",name = "foodName",value = "菜名",required = true,dataType = "String")
    public Result delFood(@RequestParam("foodName") String foodName){
        redisService.zDel(UserKey.USER_KEY,TEST,foodName);
        return Result.success();
    }
    @RequestMapping(value = "ping",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "测试服务器通常",notes = "通常则返回pong")
    public String ping(){
        return "pong";
    }
}
