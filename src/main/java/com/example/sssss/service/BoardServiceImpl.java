package com.example.sssss.service;

import com.example.sssss.domain.Board;
import com.example.sssss.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepo;

    public List<Board> getBoardList(Board board) {
        return (List<Board>) boardRepo.findAll();
        //BoardRepository의 findAll()메소드를 통해 BOARD데이블의 모든 데이터를 가져와 리턴함
    }

    @Override
    public void insertBoard(Board board) {
        boardRepo.save(board);
        // 매개변수로 받은 엔티티를 BoardRepository의 save()를 통해 영속화하는 것으로 간단하게 구현
    }

    @Override
    public Board getBoard(Board board) {
        return boardRepo.findById(board.getSeq()).get();
        //BoardRepository의 findById() 메소드를 통해 특정게시글을 상세조회하여 리턴한다
    }

    @Override
    public void updateBoard(Board board) {
        Board findBoard = boardRepo.findById(board.getSeq()).get();

        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepo.save(findBoard);
        ///JPA가 영속성 컨텍스트에 저장된 스냅샷과 비교하여 변경된 값들로 수정하는 UPDATE구문을 SQL저장소에 등록
    }

    @Override
    public void deleteBoard(Board board) {
        boardRepo.deleteById(board.getSeq());
    }

}