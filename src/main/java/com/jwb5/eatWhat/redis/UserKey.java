package com.jwb5.eatWhat.redis;

public class UserKey extends BasePrefix {

    public UserKey(int expireTime, String prefix) {
        super(expireTime, prefix);
    }

    public UserKey(String prefix) {
        super(prefix);
    }

    public static final UserKey USER_KEY = new UserKey("uk");
}
