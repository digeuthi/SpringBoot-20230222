package com.dahye.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dahye.board.dto.request.auth.SignInRequestDto;
import com.dahye.board.dto.request.auth.SignUpRequestDto;
import com.dahye.board.dto.response.ResponseDto;
import com.dahye.board.dto.response.auth.SignInResponseDto;
import com.dahye.board.service.AuthService;

@RestController
@RequestMapping("api/v2/auth")
public class AuthController {
    
    private AuthService authService;

    @Autowired //의존성 주입
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("sign-up")
    public ResponseEntity<ResponseDto> signUp(
        @Valid @RequestBody SignUpRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = authService.signUp(requestBody);
        return response;
    }

    @PostMapping("sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(
        @Valid @RequestBody SignInRequestDto requestBody
    ){
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }
}
