package com.dahye.board.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dahye.board.dto.response.ResponseDto;

public class CustomResponse {
    
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

    public static ResponseEntity<ResponseDto> notExistBoardNumber(){
        ResponseDto errorBody  = new ResponseDto("NB", "Non-Existent Board Number");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }
}
