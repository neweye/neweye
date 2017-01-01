package com.neweye.admin.action;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.iBatis.QnaDAO_iBatis;
import com.neweye.action.Action;
import com.neweye.dao.QnaDAO;
import com.neweye.dto.QnaVO;

public class AdminQnaDetailAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "qna/qnaDetail.jsp";

    String qseq = request.getParameter("qseq").trim();

    /*QnaDAO qnaDAO = QnaDAO_JDBC.getInstance();*/
    QnaDAO qnaDAO = QnaDAO_iBatis.getInstance();
    QnaVO qnaVO=null;
   try {
      qnaVO = qnaDAO.getQna(Integer.parseInt(qseq));
   } catch (NumberFormatException e) {
      e.printStackTrace();
   } catch (SQLException e) {
      e.printStackTrace();
   }

    request.setAttribute("qnaVO", qnaVO);
        
    return url;
  }
}