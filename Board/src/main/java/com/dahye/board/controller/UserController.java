package com.dahye.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dahye.board.dto.request.user.PostUserRequestDto;
import com.dahye.board.dto.response.ResponseDto;
import com.dahye.board.service.UserService;

@RestController
@RequestMapping("/api/v1/user") //모듈설정..
public class UserController {
     
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> postUser(
        @Valid @RequestBody PostUserRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = userService.postUser(requestBody);
        return response;
    }
}
