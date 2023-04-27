package com.dahye.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dahye.board.dto.request.board.PostBoardRequestDto;
import com.dahye.board.dto.response.ResponseDto;
import com.dahye.board.service.BoardService;

@RestController
@RequestMapping("/api/v1/board")
public class BoardController {
    
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){ //생성자만들어서 DI한건가?
        this.boardService = boardService;
    }

    // 1. 게시물 작성
    @PostMapping("") //추가적인 path는 없음
    public ResponseEntity<ResponseDto> postBoard(
        @Valid @RequestBody PostBoardRequestDto requestBody //흠 이거 뭐하는 작업이지
    ){
        ResponseEntity<ResponseDto> response = boardService.postBoard(requestBody);
        return response;
    }

}
