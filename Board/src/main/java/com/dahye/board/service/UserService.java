package com.dahye.board.service;

import org.springframework.http.ResponseEntity;

import com.dahye.board.dto.request.user.PostUserRequestDto;
import com.dahye.board.dto.response.ResponseDto;

public interface UserService {
    
    public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto);
}
