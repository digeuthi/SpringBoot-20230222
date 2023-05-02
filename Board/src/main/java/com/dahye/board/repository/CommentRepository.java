package com.dahye.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dahye.board.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{
    
    List<CommentEntity> findByBoardNumber(int boardNumber);
    @Transactional
    void deleteByBoardNumber(int boardNumber);
}
