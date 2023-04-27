package com.dahye.board.dto.response.board;

import com.dahye.board.dto.response.ResponseDto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBoardResponseDto extends ResponseDto {
    
    private int boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImageUrl;
    private String boardWriteDatetime;
    private int viewCount;
    private String boardWriterEmail;
    private String boardWirterNickname;
    private String boardWriterProfieImageUrl;
    private List<Comment> CommentList;
    private List<Liky> likeList; 
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Comment {
    private int commentNumber;
    private int boardNumber;
    private String commentWirterEmail;
    private String commentContent;
    private String commentWriterNickname;
    private String commentWirterProfileImageUrl;
    private String commentWriterDatetime;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Liky {
    private int boardNumber;
    private String userEmail;
    private String userNickname;
    private String userProfileImageUrl;
}
