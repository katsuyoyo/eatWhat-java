package com.jwb5.eatWhat.redis;

/**
 * Created by jiangwenbin on 2019/1/8.
 */
public interface KeyPrefix {
    int expireTime();
    String getPrefix();
}
