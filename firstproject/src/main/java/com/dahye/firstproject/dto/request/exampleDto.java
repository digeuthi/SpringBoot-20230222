package com.dahye.firstproject.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter //안의 내용도 꺼내야하기때문에 getter사용함
@ToString //리퀘스트 잘못들어온걸 디버깅할때 필요하다
public class exampleDto {
    
    private String parameter1;
    private String parameter2;
    private String parameter3;

    //기본생성자로 세터는 필요한데 이걸 롬복이용해서 만든다

}
//request에 대한 dto는 이정도만 필요하다