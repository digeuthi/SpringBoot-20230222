package com.dahye.board.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dahye.board.common.util.CustomResponse;
import com.dahye.board.dto.request.auth.SignInRequestDto;
import com.dahye.board.dto.request.auth.SignUpRequestDto;
import com.dahye.board.dto.response.ResponseDto;
import com.dahye.board.dto.response.auth.SignInResponseDto;
import com.dahye.board.repository.UserRepository;
import com.dahye.board.service.AuthService;

@Service //이게 없으면 실행 오류가 뜰수있다.
public class AuthServiceImplement implements AuthService {
    
    //사용할 레포 올려두기
    private UserRepository userRepository;

    //BCryptPasswordEncoder 사용
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImplement(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); //이건 외부에서 받아오지 않고 직접만든다
    }

    //밑에 2개 빠른 수정으로 생성
    @Override
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {
        
        String email = dto.getUserEmail();
        String nickname = dto.getUserNickname();
        String phoneNumber = dto.getUserPhoneNumber();

        try {

            // 존재하는 유저 이메일 반환
            boolean existedUserEmail = userRepository.existsByEmail(email);
            if(existedUserEmail) return CustomResponse.existUserEmail();

            // 존재하는 유저 닉네임 반환
            boolean existedUserNickname = userRepository.existsByNickname(nickname);
            if(existedUserNickname) return CustomResponse.existUserNickname();
            // 존재하는 유저 휴대폰 번호 반환
            boolean existedUserPhoneNumber = userRepository.existsByPhoneNumber(phoneNumber);
            if(existedUserPhoneNumber) return CustomResponse.existUserPhoneNumber();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'signIn'");
    }
}
