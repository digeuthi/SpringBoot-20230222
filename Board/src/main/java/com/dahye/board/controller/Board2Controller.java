package com.dahye.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dahye.board.dto.request.board.PatchBoardRequestDto;
import com.dahye.board.dto.request.board2.PostBoardRequestDto2; //복사한 dto로 바꿔줌
import com.dahye.board.dto.response.ResponseDto;
import com.dahye.board.dto.response.board.GetBoardListResponseDto;
import com.dahye.board.dto.response.board.GetBoardResponseDto;
import com.dahye.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v2/board")
@RequiredArgsConstructor //final만 추가해주고 만들어주면 의존성 외부주입 알아서 해준다
public class Board2Controller {
    
    private final BoardService boardService;

    

    // 1. 게시물 작성 //글쓴이 이메일 받지 않고 인증처리를 통해서 가져오는걸로 하게된다.
    @PostMapping("") //추가적인 path는 없음
    public ResponseEntity<ResponseDto> postBoard(
        @AuthenticationPrincipal String userEmail, //인증을 거친 email을 받아오는것
        //JwtAuthenticationFilter의 AbstractAuthenticationToken에서 email을 받아오므로 그걸 사용하는것
        @Valid @RequestBody PostBoardRequestDto2 requestBody //흠 이거 뭐하는 작업이지
    ){
        ResponseEntity<ResponseDto> response = boardService.postBoard(userEmail, requestBody);
        return response;
    }

    // 2. 특정 게시물 조회
    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
        @PathVariable("boardNumber") Integer boardNumber  //Integer로 한 이유가 있나?
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
