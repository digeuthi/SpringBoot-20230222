package com.dahye.board.repository;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dahye.board.entity.BoardEntity;
import com.dahye.board.entity.resultSet.BoardListResultSet;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> { 
    //레포지토리는 jpa레포지토리를 확장받고, 제너릭 타입으로 엔터티와, 그 엔터티의 PK타입 적는다

    public BoardEntity findByBoardNumber(int boardNumber); //게시글번호 조회

    @Query(
        value=
        "SELECT " +
        "B.board_number AS boardNumber," +
        "B.title AS boardTitle,"+
        "B.content AS boardContent,"+
        "B.board_image_url AS boardImageUrl," +
        "B.write_datetime AS boardWriteDateTime," +
        "B.view_count AS ViewCount," +
        "U.email AS boardWriterNickname," +
        "U.profile_image_url AS boardWriterProfileImageUrl,"+
        "count(distinct C.comment_number) AS commentCount,"+
        "count(distinct L.user_email) AS likeCount " +
        "FROM Board B, Comment C, Liky L, User U " +
        "WHERE B.board_number = C.board_number "+
        "AND B.board_number = L.board_number "+
        "AND B.writer_email = U.email "+
        "GROUP BY B.board_number "+
        "ORDER BY B.write_datetime DESC",
        nativeQuery = true
        )
    public List<BoardListResultSet> getList(); //제너릭 바꿔줌.

    @Query(
        value=
        "SELECT " +
        "B.board_number AS boardNumber," +
        "B.title AS boardTitle,"+
        "B.content AS boardContent,"+
        "B.board_image_url AS boardImageUrl," +
        "B.write_datetime AS boardWriteDateTime," +
        "B.view_count AS ViewCount," +
        " U.email AS boardWriterNickname," +
        "U.profile_image_url AS boardWriterProfileImageUrl,"+
        "count(distinct C.comment_number) AS commentCount,"+
        "count(distinct L.user_email) AS likeCount" +
        "FROM Board B, Comment C, Liky L, User U " +
        "WHERE B.board_number = C.board_number "+
        "AND B.board_number = L.board_number "+
        "AND B.writer_email = U.email "+
        "GROUP BY B.board_number "+
        "ORDER BY LikeCount DESC " +
        "LiMIT 3",
        nativeQuery = true
        )
    public List<BoardListResultSet> getTop3List();
}
