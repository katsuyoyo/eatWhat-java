package com.jwb5.eatWhat.dao;

import com.jwb5.eatWhat.model.User;
import com.jwb5.eatWhat.redis.RedisService;
import com.jwb5.eatWhat.redis.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @Autowired
    RedisService redisService;

    public boolean insertUser(User user){
        return redisService.set(UserKey.USER_KEY,user.getUserId(),user);
    }

}
