package com.dahye.board.dto.request.board;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class PatchBoardRequestDto {
    
    @NotBlank
    @Email
    private String userEmail;
    @NonNull
    private Integer boardNumber; //필수값 int는 기본형타입이라서 null을 받을수 없으므로 Integer로 입력
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageUrl;
}
