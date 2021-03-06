package com.jwb5.eatWhat.redis;

import com.google.common.base.Strings;
import com.jwb5.eatWhat.Util.String2ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.util.Set;

@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    public <T> T get(KeyPrefix prefix,String key,Class<T> clazz ){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix()+key;
            String str = jedis.get(realKey);
            T t = String2ObjectUtil.string2Bean(str,clazz);
            return t;
        }finally {
            return2Pool(jedis);
        }

    }

    private void return2Pool(Jedis jedis){
        if (jedis!=null){
            jedis.close();
        }
    }

    public <T> boolean set(KeyPrefix prefix,String key,T value ){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = String2ObjectUtil.bean2String(value);

            if (Strings.isNullOrEmpty(str)){
                return false;
            }

            String realKey = prefix.getPrefix()+key;
            int time = prefix.expireTime();
            if (time<=0){
                jedis.set(realKey,str);
            }else {
                jedis.setex(realKey,time,str);
            }
            return true;
        }finally {
            return2Pool(jedis);
        }

    }


    public boolean exit(KeyPrefix prefix,String key){
        Jedis jedis = null;
        try {
            jedis=jedisPool.getResource();
            String realKey = prefix.getPrefix()+key;
            return jedis.exists(realKey);
        }finally {
            return2Pool(jedis);
        }
    }

    public Long incr(KeyPrefix prefix,String key){
        Jedis jedis = null;
        try {
            jedis=jedisPool.getResource();
            String realKey = prefix.getPrefix()+key;
            return jedis.incr(realKey);
        }finally {
            return2Pool(jedis);
        }
    }

    public Long decr(KeyPrefix prefix,String key){
        Jedis jedis = null;
        try {
            jedis=jedisPool.getResource();
            String realKey = prefix.getPrefix()+key;
            return jedis.decr(realKey);
        }finally {
            return2Pool(jedis);
        }
    }

    public Long del(KeyPrefix prefix,String key){
        Jedis jedis = null;
        try {
            jedis=jedisPool.getResource();
            String realKey = prefix.getPrefix()+key;
            return jedis.del(realKey);
        }finally {
            return2Pool(jedis);
        }
    }


    public <T> Long zAdd(KeyPrefix prefix,String key,double score,T value){
        Jedis jedis = null;
        try {
            jedis=jedisPool.getResource();
            String realKey = prefix.getPrefix()+key;
            return jedis.zadd(realKey,score,String2ObjectUtil.bean2String(value));
        }finally {
            return2Pool(jedis);
        }
    }

    public <T> Long zDel(KeyPrefix prefix,String key,T value){
        Jedis jedis = null;
        try {
            jedis=jedisPool.getResource();
            String realKey = prefix.getPrefix()+key;
            return jedis.zrem(realKey,String2ObjectUtil.bean2String(value));
        }finally {
            return2Pool(jedis);
        }
    }

    public Set<Tuple> zRange(KeyPrefix prefix, String key, long start, long end){
        Jedis jedis = null;
        try {
            jedis=jedisPool.getResource();
            String realKey = prefix.getPrefix()+key;
            return jedis.zrangeWithScores(realKey,start,end);
        }finally {
            return2Pool(jedis);
        }
    }
}
