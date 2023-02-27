package com.example.sssss.service;

import com.example.sssss.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> getBoardList(Board board);
    void insertBoard(Board board);
    Board getBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Board board);
}