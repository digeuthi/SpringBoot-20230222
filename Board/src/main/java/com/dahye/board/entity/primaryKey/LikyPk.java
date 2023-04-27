package com.dahye.board.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class LikyPk implements Serializable { //엔터티로 쓰이기위해서 Serializable 사용
    
    @Column(name="board_number")
    private int boardNumber;

    @Column(name = "user_email")
    private String userEmail;
}
