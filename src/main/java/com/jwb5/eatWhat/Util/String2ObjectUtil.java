package com.jwb5.eatWhat.Util;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;

public class String2ObjectUtil {


    public static <T> T string2Bean(String str, Class<T> clazz){

        if (Strings.isNullOrEmpty(str)){
            return null;
        }

        if (clazz == int.class || clazz == Integer.class){
            return (T)Integer.valueOf(str);
        }
        if (clazz == long.class || clazz == Long.class){
            return (T)Long.valueOf(str);
        }
        if (clazz == String.class){
            return (T)str;
        }

        return JSON.toJavaObject(JSON.parseObject(str),clazz);
    }

    public static <T> String bean2String(T value){
        if (value == null){
            return null;
        }
        Class<?> clazz = value.getClass();

        if (clazz == int.class || clazz == Integer.class){
            return ""+value;
        }
        if (clazz == long.class || clazz == Long.class){
            return ""+value;
        }
        if (clazz == String.class){
            return (String)value;
        }

        return JSON.toJSONString(value);
    }
}
