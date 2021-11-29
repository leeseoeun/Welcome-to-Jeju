package com.welcomeToJeju.wtj.web;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.BoardDao;
import com.welcomeToJeju.wtj.domain.Board;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class BoardController {

  @Autowired BoardDao boardDao;
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


}