package com.welcomeToJeju.wtj.web;

import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.BoardCommentDao;
import com.welcomeToJeju.wtj.dao.BoardDao;
import com.welcomeToJeju.wtj.domain.Board;
import com.welcomeToJeju.wtj.domain.BoardComment;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class BoardController {

  @Autowired BoardDao boardDao;
  @Autowired BoardCommentDao boardCommentDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @GetMapping("/board/addform")
  public ModelAndView addForm() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "게시글 등록하기");
    mv.addObject("contentUrl", "board/BoardAddForm.jsp");
    mv.setViewName("template_main");
    return mv;
  }

  @PostMapping("/board/add")
  public ModelAndView add(Board board, HttpSession session) throws Exception {
    board.setWriter((User) session.getAttribute("loginUser"));

    boardDao.insert(board);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");

    return mv;
  }

  @RequestMapping("/board/list")
  public ModelAndView list() throws Exception {
    Collection<Board> boardList = boardDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("boardList", boardList);
    mv.addObject("pageTitle", "게시글 목록 보기");
    mv.addObject("contentUrl", "board/BoardList.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  @GetMapping("/board/detail")
  public ModelAndView detail(int no, HttpSession session) throws Exception {

    User user = (User) session.getAttribute("loginUser");
    Board board = boardDao.findByNo(no);
    List<BoardComment> boardComment = boardCommentDao.findByBoardNo(board.getNo());

    boardDao.updateViewCount(no);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.addObject("board", board);
    mv.addObject("boardComment", boardComment);
    mv.addObject("pageTitle", "게시글 상세 보기");

    if (user == null || user.getNo() != board.getWriter().getNo()) {
      mv.addObject("contentUrl", "board/BoardDetail.jsp");

    } else if (user.getNo() == board.getWriter().getNo()) {
      mv.addObject("contentUrl", "board/MyBoardDetail.jsp");
    }
    mv.setViewName("template_main");

    return mv;
  }

  @PostMapping("/board/update")
  public ModelAndView update(Board board) throws Exception {
    Board oldBoard = boardDao.findByNo(board.getNo());
    if (oldBoard == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 

    boardDao.update(board);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");

    return mv;
  }

  @GetMapping("/board/delete")
  public ModelAndView delete(int no) throws Exception {
    Board board = boardDao.findByNo(no);
    if (board == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    boardDao.delete(no);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");

    return mv;
  }


}
