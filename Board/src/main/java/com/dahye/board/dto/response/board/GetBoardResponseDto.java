package com.dahye.board.dto.response.board;

import com.dahye.board.dto.response.ResponseDto;
import com.dahye.board.entity.BoardEntity;
import com.dahye.board.entity.CommentEntity;
import com.dahye.board.entity.LikyEntity;
import com.dahye.board.entity.UserEntity;

import java.util.ArrayList;
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
    private List<Comment> commentList;
    private List<Liky> likeList; 

    public GetBoardResponseDto(BoardEntity boardEntity, UserEntity userEntity,
            List<CommentEntity> commentEntities, List<LikyEntity> likyEntities 
            ){
                super("Su", "Success");
                // List<Comment> commentlList = new ArrayList<>();
                // for(CommentEntity commentEntity : commentEntities){

                // }
                // List<Liky> likeList = new ArrayList<>();
                // for(LikyEntity likyEntity : likyEntities){
                    
                // }

                
                this.boardNumber = boardEntity.getBoardNumber();
                this.boardTitle = boardEntity.getTitle();
                this.boardContent = boardEntity.getContent();
                this.boardImageUrl = boardEntity.getBoardImageUrl();
                this.boardWriteDatetime = boardEntity.getWriteDateTime();
                this.viewCount = boardEntity.getViewCount();
                this.boardWriterEmail = userEntity.getEmail();
                this.boardWirterNickname = userEntity.getNickname();
                this.boardWriterProfieImageUrl = userEntity.getProfileImageUrl();
                this.commentList = Comment.createList(commentEntities);
                this.likeList = Liky.createList(likyEntities);
            }
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
    private String commentWriteDatetime;

    Comment(CommentEntity commentEntity){
        this.commentNumber = commentEntity.getCommentNumber();
        this.boardNumber = commentEntity.getBoardNumber();
        this.commentWirterEmail = commentEntity.getUserEmail();
        this.commentContent = commentEntity.getCommentContent();
        this.commentWriterNickname = commentEntity.getUserNickname();
        this.commentWirterProfileImageUrl = commentEntity.getUserProfileImageUrl();
        this.commentWriteDatetime = commentEntity.getWirteDateTime();
    }

    static List<Comment> createList(List<CommentEntity> commentEntities) { //필요한 값들만 넣기 위해서 복사하는 행위..
        List<Comment> commentlList = new ArrayList<>();
                for(CommentEntity commentEntity : commentEntities){
                    Comment comment = new Comment(commentEntity);
                    commentlList.add(comment);
                }
        return commentlList;
    }
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

    Liky(LikyEntity likyEntity){
        this.boardNumber = likyEntity.getBoardNumber();
        this.userEmail = likyEntity.getUserEmail();
        this.userNickname = likyEntity.getUserNickname();
        this.userProfileImageUrl = likyEntity.getUserProfileImageUrl();
    }

    static List<Liky> createList(List<LikyEntity> likyEntities){
        List<Liky> likeList = new ArrayList<>();
                for(LikyEntity likyEntity : likyEntities){
                    Liky liky = new Liky(likyEntity);
                    likeList.add(liky);
                }
                return likeList;
    }
}
