package com.jwb5.eatWhat.service;


import com.jwb5.eatWhat.Exception.ServiceException;
import com.jwb5.eatWhat.Util.HttpConnectionUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public interface LoginService {

    String code2Session(String code);
}
