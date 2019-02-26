package com.jwb5.eatWhat.service;


import com.jwb5.eatWhat.Exception.ServiceException;

import java.net.MalformedURLException;
import java.net.URL;

public interface LoginService {


    String getSessionUrl(String code);


    default String code2Session(String url) throws Exception {

        URL u = new URL(url);

        return null;
    }
}
