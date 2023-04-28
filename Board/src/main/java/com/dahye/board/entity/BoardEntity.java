package com.dahye.board.entity;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dahye.board.dto.request.board.PostBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Board")
@Table(name = "Board") //어떤 db와 맵핑할지 지정
public class BoardEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //오토인클리먼트 설정
    private int boardNumber;
    private String writerEmail;
    private String title;
    private String content;
    private String boardImageUrl;
    private String writeDatetime;
    private int viewCount;

    public BoardEntity(PostBoardRequestDto dto){ //생성자 만들기

        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.writerEmail = dto.getBoardWriterEmail();
        this.title= dto.getBoardTitle();
        this.content = dto.getBoardContent();
        this.boardImageUrl = dto.getBoardImageUrl();
        this.writeDatetime = writeDatetime; //생성자가 돌아가는 시점으로 
        this.viewCount = 0; //만들어지면 초기값이 무조건 0
    }

}
