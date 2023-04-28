package com.dahye.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.dahye.board.entity.primaryKey.LikyPk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Liky")
@Table(name = "Liky")
@IdClass(LikyPk.class) //복합프라이머리 키 사용위해 만든 pk를 지정해준것
public class LikyEntity { //복합 프라이머리 키
    
    @Id
    private int boardNumber;
    @Id
    private String userEmail;
    private String userNickname;
    private String userProfileImageUrl;
    
}
