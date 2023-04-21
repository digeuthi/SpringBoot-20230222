package com.dahye.firstproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


//@Setter
//@Getter
@Builder
//@ToString
@Data //주석처리한것 포함 다른것들을 기본적으로 다 생성해주게한다.
@AllArgsConstructor // 세가지 모두 매개변수로 받아오는 생성자
public class ExampleResponseDto {
    private String data1;
    private String data2;
    private String data3;
    //멤버변수를 다 받는 생성자가 기본적으로 쓰임
}
