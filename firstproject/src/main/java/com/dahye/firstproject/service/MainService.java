package com.dahye.firstproject.service;

import org.springframework.stereotype.Component;


public interface MainService {
    public String hello();
    public String getJwt(String data);
    public String validJwt(String jwt);
}
