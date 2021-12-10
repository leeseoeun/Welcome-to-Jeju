package com.welcomeToJeju.wtj.web;

import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.BoardCommentDao;
import com.welcomeToJeju.wtj.dao.BoardDao;
import com.welcomeToJeju.wtj.domain.BoardComment;

@Controller
public class BoardCommentController {

  @Autowired BoardCommentDao boardCommentDao;
  @Autowired BoardDao boardDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @PostMapping("/boardcomment/add")
  public ModelAndView add(BoardComment boardComment, HttpSession session) throws Exception {
    boardCommentDao.insert(boardComment);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.addObject("board", boardComment.getBoard());
    mv.setViewName("redirect:../board/detail?no=" + boardComment.getBoard().getNo());

    return mv;
  }

  @GetMapping("/boardcomment/delete")
  public ModelAndView delete(int no, int boardNo) throws Exception {
    BoardComment boardComment = boardCommentDao.findByNo(no);

    boardCommentDao.delete(boardComment.getNo());
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../board/detail?no=" + boardDao.findByNo(boardNo).getNo());

    return mv;
  }


}
