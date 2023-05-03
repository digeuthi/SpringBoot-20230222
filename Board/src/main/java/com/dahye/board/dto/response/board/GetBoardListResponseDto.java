package com.dahye.board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.dahye.board.dto.response.ResponseDto;
import com.dahye.board.entity.resultSet.BoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
//@AllArgsConstructor 생성자 만들어줄때 List 관련해서 값이 2개가 되므로 지운건가
public class GetBoardListResponseDto extends ResponseDto{
    private List<BoardSummary> boardList;

    public GetBoardListResponseDto(List<BoardListResultSet> resultSet){
        super("SU", "Success");

        List<BoardSummary> boardList = new ArrayList<>();

        for(BoardListResultSet result : resultSet){
            BoardSummary boardSummary = new BoardSummary(result);
            boardList.add(boardSummary);
        }

        this.boardList = boardList;
    }

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class BoardSummary {
    private int boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImageUrl;
    private String boardWriteDatetime;
    private int viewCount;
    private String boardWriterEmail;
    private String boardWirterNickname;
    private String boardWriterProfieImageUrl;
    private int CommenCount;
    private int likeCount; 

    public BoardSummary(BoardListResultSet resultSet){
        this.boardNumber = resultSet.getBoardNumber();
        this.boardTitle = resultSet.getBoardTitle();
        this.boardContent = resultSet.getBoardContent();
        this.boardImageUrl = resultSet.getBoardImageUrl();
        this.boardWriteDatetime = resultSet.getBoardWirteDateTime();
        this.viewCount = resultSet.getViewCount();
        this.boardWriterEmail = resultSet.getBoardWirterEmail();
        this.boardWirterNickname = resultSet.getBoardWirterNickname();
        this.boardWriterProfieImageUrl = resultSet.getBoardWriterProfileImageUrl();
        this.CommenCount = resultSet.getCommentCount();
        this.likeCount = resultSet.getLikeCount();
    }
}