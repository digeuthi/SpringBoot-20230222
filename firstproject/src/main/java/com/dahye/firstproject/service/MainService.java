package com.dahye.firstproject.service;

import org.springframework.stereotype.Component;

import com.dahye.firstproject.provider.UserRole;


public interface MainService {
    public String hello();
    public String getJwt(String data);
    public UserRole validJwt(String jwt);
}
