package com.dahye.board.dto.request.board2;

import javax.validation.constraints.NotBlank;

import com.dahye.board.dto.request.board.PatchBoardRequestDto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class PatchBoardRequestDto2 {
    
    @NonNull
    private Integer boardNumber; //필수값 int는 기본형타입이라서 null을 받을수 없으므로 Integer로 입력
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageUrl;

    public PatchBoardRequestDto2(PatchBoardRequestDto dto){
        this.boardNumber = dto.getBoardNumber();
        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
        this.boardImageUrl = dto.getBoardImageUrl();
    }
}
