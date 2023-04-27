package com.dahye.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dahye.board.dto.request.board.PatchBoardRequestDto;
import com.dahye.board.dto.request.board.PostBoardRequestDto;
import com.dahye.board.dto.response.ResponseDto;
import com.dahye.board.dto.response.board.GetBoardListResponseDto;
import com.dahye.board.dto.response.board.GetBoardResponseDto;
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

    // 2. 특정 게시물 조회
    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
        @PathVariable("boadrNumber") Integer boardNumber  //Integer로 한 이유가 있나?
    ){
        ResponseEntity<? super GetBoardResponseDto> response =
            boardService.getBoard(boardNumber);
        return response;
    }

    // 3. 게시물 목록 조회
    @GetMapping("/list")
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList(){
        ResponseEntity<? super GetBoardListResponseDto> response =
            boardService.getBoardList();
        return response;
    }

    // 4. top3 게시물 목록조회
    @GetMapping("/top3")
    public ResponseEntity<? super GetBoardListResponseDto> getBoardTop3(){
        ResponseEntity<? super GetBoardListResponseDto> response =
            boardService.getBoardTop3();
        return response;
    }

    // 5. 특정 게시물 수정
    @PatchMapping("") //이거 경로있고 없고의 차이는 뭐지
    public ResponseEntity<ResponseDto> patchBoard( //매개변수 받고 아니고의 차이는 뭐지
        @Valid @RequestBody PatchBoardRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = 
            boardService.patchBoard(requestBody);
        return response;
    }

    // 6. 특정 게시물 삭제
    @DeleteMapping("/{userEmail}/{boardNumber}")
    public ResponseEntity<ResponseDto> deleteBoard(
        @PathVariable("userEmail") String userEmail,
        @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<ResponseDto> response =
            boardService.deleteBoard(userEmail, boardNumber);
        return response;
    }
}
