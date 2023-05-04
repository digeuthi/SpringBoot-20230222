package com.dahye.board.service;

import org.springframework.http.ResponseEntity;

import com.dahye.board.dto.request.auth.SignInRequestDto;
import com.dahye.board.dto.request.auth.SignUpRequestDto;
import com.dahye.board.dto.response.ResponseDto;
import com.dahye.board.dto.response.auth.SignInResponseDto;

public interface AuthService {
    
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
