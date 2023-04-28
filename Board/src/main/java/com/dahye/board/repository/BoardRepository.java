package com.dahye.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dahye.board.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> { 
    //레포지토리는 jpa레포지토리를 확장받고, 제너릭 타입으로 엔터티와, 그 엔터티의 PK타입 적는다

    public BoardEntity findByBoardNumber(int boardNumber); //게시글번호 조회
}
