package com.dahye.firstproject.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Data
public class exampleDto {

    @NotNull
    private String parameter1;
    @Length(min = 0, max = 20) //data2의 길이를 20이상으로 지정하게 되면 400의 오류가 뜨게된다
    private String parameter2;
    private String parameter3;

    //기본생성자로 세터는 필요한데 이걸 롬복이용해서 만든다

}
//request에 대한 dto는 이정도만 필요하다