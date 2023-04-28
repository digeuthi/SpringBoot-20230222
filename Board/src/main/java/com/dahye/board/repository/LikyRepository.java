package com.dahye.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dahye.board.entity.LikyEntity;
import com.dahye.board.entity.primaryKey.LikyPk;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, LikyPk>{ //Liky는 복합기본키를 가지고 둘다 타입이 다른경우
    //복합키의 경우 기본타입을 만들어줄수 없고 pk에 대한 타입을 만들어줘야한다! -> LikyPk 만들어서 지정해줌
    
    List<LikyEntity> findByBoardNumber(int boardNumber);
}
