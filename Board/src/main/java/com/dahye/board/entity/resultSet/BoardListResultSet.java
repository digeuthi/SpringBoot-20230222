package com.dahye.board.entity.resultSet;

public interface BoardListResultSet {
    public int getBoardNumber();
    public String getBoardTitle();
    public String getBoardContent();
    public String getBoardImageUrl();
    public String getBoardWirteDateTime();
    public int getViewCount();
    public String getBoardWirterEmail();
    public String getBoardWirterNickname();
    public String getBoardWriterProfileImageUrl();
    public int getCommentCount();
    public int getLikeCount();
}
