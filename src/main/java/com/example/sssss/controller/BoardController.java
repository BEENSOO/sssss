package com.example.sssss.controller;

import com.example.sssss.domain.Board;
import com.example.sssss.domain.Member;
import com.example.sssss.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SessionAttributes("member")
@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @ModelAttribute("member")
    public Member setMember(){
        return new Member();
    } //*추가

    /*---------READ---------*/
    //게시글상세
    @GetMapping("/getBoard")
    public String getBoard(@ModelAttribute("member")Member member, Board board, Model model){
        if(member.getId() == null){
            return "redirect:login";
        } //*추가
        model.addAttribute("board", boardService.getBoard(board));
        return "getBoard";
    }

    //게시글목록
    @RequestMapping("/getBoardList")
    public String getBoardList(@ModelAttribute("member")Member member, Model model, Board board){
        if(member.getId() == null){
            return "redirect:login";
        } //*추가

        List<Board> boardList = boardService.getBoardList(board);

        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }
    /*---------CREATE---------*/
    //게시글등록
    @GetMapping("/insertBoard")
    public String insertBoardView(@ModelAttribute("member") Member member){
        if(member.getId() == null){
            return "redirect:login";
        } //*추가
        return "insertBoard";
    }
    //게시글등록
    @PostMapping("/insertBoard")
    public String insertBoard(Board board){
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }
    /*---------UPDATE---------*/
    //게시글수정
    @PostMapping("/updateBoard")
    public String updateBoard(@ModelAttribute("member")Member member, Board board){
        if(member.getId() == null){
            return "redirect:login";
        } //*추가
        boardService.updateBoard(board);
        return "forward:getBoardList";
    }
    /*---------DELETE---------*/
    //게시글삭제
    @GetMapping("/deleteBoard")
    public String deleteBoard(@ModelAttribute("member")Member member,Board board){
        if(member.getId() == null){
            return "redirect:login";
        } //*추가
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }
}