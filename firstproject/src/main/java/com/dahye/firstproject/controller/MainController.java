package com.dahye.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dahye.firstproject.service.MainService;
import com.dahye.firstproject.service.implement.MainServeceImplement;

@RestController
public class MainController {
    
    private final MainService mainService;

    @Autowired //IOC를 적용할수 있다.
    public MainController(MainService mainService){
        this.mainService = mainService;
    }

    @GetMapping("/hello")
    public String hello(){
        return mainService.hello();
    }

    @GetMapping("/jwt/{data}")
    public String getJwt(
        @PathVariable("data") String data
        ){
        return mainService.getJwt(data);
    }

    @PostMapping("/jwt")
    public String validJwt(
        @RequestBody String jwt
    ){
        return mainService.validJwt(jwt);
    }
}
