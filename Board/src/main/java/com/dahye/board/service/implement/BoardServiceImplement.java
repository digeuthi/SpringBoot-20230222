package com.dahye.board.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dahye.board.common.util.CustomResponse;
import com.dahye.board.dto.request.board.PatchBoardRequestDto;
import com.dahye.board.dto.request.board.PostBoardRequestDto;
import com.dahye.board.dto.response.ResponseDto;
import com.dahye.board.dto.response.board.GetBoardListResponseDto;
import com.dahye.board.dto.response.board.GetBoardResponseDto;
import com.dahye.board.entity.BoardEntity;
import com.dahye.board.entity.CommentEntity;
import com.dahye.board.entity.LikyEntity;
import com.dahye.board.entity.UserEntity;
import com.dahye.board.repository.BoardRepository;
import com.dahye.board.repository.CommentRepository;
import com.dahye.board.repository.LikyRepository;
import com.dahye.board.repository.UserRepository;
import com.dahye.board.service.BoardService;

@Service
public class BoardServiceImplement implements BoardService {

    private UserRepository userRepository;
    private BoardRepository boardRepository;
    private CommentRepository commentRepository;
    private LikyRepository likyRepository;

    @Autowired
    public BoardServiceImplement(UserRepository userRepository, 
        BoardRepository boardRepository, 
        CommentRepository commentRepository, 
        LikyRepository likyRepository){
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
        this.likyRepository = likyRepository;
    } //생성자 안만들고 위에 선언할때 Autowierd써서 사용해도 되지만 생성할때 생성할수가 없어서 이렇게 생성자 만들어서 사용중
        //권장사항이기도 하고 다른 외부 프레임워크에서도 이런 방식을 추천해서 사용한다.
        //아니면 선언때 final 걸어주고 Required..하는거 public위에 어노테이션 추가하면 생성자 만드는것과 같은 효과를 얻을수 있다.

    @Override
    public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto) {
       
        ResponseDto body = null;

        String boardWriterEmail = dto.getBoardWriterEmail(); //이메일 가져오는것
        //유저 레포지토리에서 유저의 유무 검색해야한다.

        try{
            //존재하지 '않는' 유저 오류 반환
            boolean existedUserEmail = userRepository.existsByEmail(boardWriterEmail);
            if(!existedUserEmail){ //존재하지 않을때니까 !붙이기
                ResponseDto errorbody = new ResponseDto("NU","Non-Existent User Email");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorbody);
            }

            //검증끝났으니까 삽입작업하기

            BoardEntity boardEntity = new BoardEntity(dto);
            boardRepository.save(boardEntity);

            body = new ResponseDto("SU","Success");

        } catch(Exception exception) {
            //데이터베이스 오류 반환
            exception.printStackTrace();
            ResponseDto errorBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }
        //성공반환
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {
        
        GetBoardResponseDto body = null;
        //ResponseDto errorBody = null;

        try{

            if (boardNumber == null) { //board의 타입은 int, Repository의 타입은 Integer이라 null은 처리를 못해주므로 검증처리
                return CustomResponse.validationFaild();
            }

            //게시물 번호 조회
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) { //존재하지 않는 게시물 번호 조회시
                return CustomResponse.notExistBoardNumber();
            }

            //User가져와서 boardWriter관련된 값 가져오기
            String boardWriterEmail = boardEntity.getWriterEmail();
            UserEntity userEntity = userRepository.findByEmail(boardWriterEmail);

            List<CommentEntity> commentEntities = commentRepository.findByBoardNumber(boardNumber);
            List<LikyEntity> likyEntities = likyRepository.findByBoardNumber(boardNumber);

            body = new GetBoardResponseDto(boardEntity, userEntity, commentEntities, likyEntities); 

        } catch(Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError(); 
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoardList'");
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardTop3() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoardTop3'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchBoard(PatchBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }
    
}
