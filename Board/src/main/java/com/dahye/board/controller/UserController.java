package com.dahye.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user") //모듈설정..
public class UserController {
     
    @PostMapping("")
    public ResponseEntity<?> postUser(){
        
    }
}
