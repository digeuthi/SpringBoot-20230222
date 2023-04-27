package com.dahye.board.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dahye.board.dto.request.user.PostUserRequestDto;
import com.dahye.board.dto.response.ResponseDto;
import com.dahye.board.entity.UserEntity;
import com.dahye.board.repository.UserRepository;
import com.dahye.board.service.UserService;

@Service
public class UserServiceImplement implements UserService {
    
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplement(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override //잘입력했는지 확인하는 용도
    public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto){
       
        // ResponseEntity<ResponseDto> result = null;
        ResponseDto responseBody = null;

        String eamil = dto.getUserEmail();
        String nickname = dto.getUserNickname();
        String phoneNumber = dto.getUserPhoneNumber();

        try{

        // 이메일 중복 반환 : 받아올 이메일을 알아야한다. DB 유저테이블에 해당 이메일이 존재하는지 찾아와야한다.
        boolean hasEmail = userRepository.existsByEmail(eamil); //존재하면 true, 아니면 false
        if(hasEmail){
                responseBody = new ResponseDto("EU", "Existent User Email");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
        // 닉네임 중복 반환 DB 유저테이블에 해당 값이 존재하는지 찾아와야한다.
        boolean hasNickname = userRepository.existsByNickname(nickname);
        if(hasNickname){
            responseBody = new ResponseDto("EN", "Existent User Nickname");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
        }

        // 휴대전화 번호 중복 반환 
        boolean hasPhoneNumber = userRepository.existsByPhoneNumber(phoneNumber);
        if(hasPhoneNumber) {
            responseBody = new ResponseDto("EP", "Existent User Phone Number");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
        }

        //삽입시에는 엔터티에 저장하고 레포에 세이브..?
        //유저 레코드 삽입
        UserEntity userEntity = new UserEntity(dto);
        userRepository.save(userEntity);

        responseBody = new ResponseDto("SU", "Success");
        

        } catch(Exception exception){

            // 데이터 베이스 오류 반환
            exception.printStackTrace();
            responseBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }

        // 성공 반환 //to_do에 해야할일 작성한 후 하나하나 작성하는게 덜 힘들다
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);


        
    }

}
