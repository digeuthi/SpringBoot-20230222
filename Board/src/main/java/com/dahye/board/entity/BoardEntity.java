package com.dahye.board.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String writeDateTime;
    private int viewCount;

}
