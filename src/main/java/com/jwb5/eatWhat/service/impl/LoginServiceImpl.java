package com.jwb5.eatWhat.service.impl;

import com.jwb5.eatWhat.service.LoginService;

public class LoginServiceImpl implements LoginService {


    private static final String APPID ="wx3f5e28a493b52e16";
    private static final String SECRET ="96af376309f4cee19cee90f708d3590e";
    private static final String GRANT_TYPE ="&grant_type=authorization_code";
    private static final String LOGIN_URL ="https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code=";


    @Override
    public String getSessionUrl(String code) {
        StringBuilder sb = new StringBuilder(LOGIN_URL);
        sb.append(code).append(GRANT_TYPE);
        return sb.toString();
    }
}
