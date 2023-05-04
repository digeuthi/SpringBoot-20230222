package com.dahye.board.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dahye.board.dto.response.ResponseDto;

public class CustomResponse {

    public static ResponseEntity<ResponseDto> success(){
        ResponseDto body = new ResponseDto("SU", "SUCESS");
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    
    public static ResponseEntity<ResponseDto> databaseError(){
        ResponseDto errorBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(errorBody);
    } 

    public static ResponseEntity<ResponseDto> validationFaild(){
        ResponseDto errorBody = 
        new ResponseDto("VF", "Request Parameter Validation Failed");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> existUserEmail(){
        ResponseDto errorBody  = new ResponseDto("EU", "Existent User Email");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> existUserNickname(){
        ResponseDto errorBody  = new ResponseDto("EN", "Existent User Nickname");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> existUserPhoneNumber(){
        ResponseDto errorBody  = new ResponseDto("EP", "Existent User Phone Number");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> notExistBoardNumber(){
        ResponseDto errorBody  = new ResponseDto("NB", "Non-Existent Board Number");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> notExistUserEmail(){ //인증할수없다
        ResponseDto errorBody  = new ResponseDto("NU", "Non-Existent User Email");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> noPermissions(){ //인가할수없다
        ResponseDto errorBody  = new ResponseDto("NP", "No Permissions");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorBody);
    }

}
