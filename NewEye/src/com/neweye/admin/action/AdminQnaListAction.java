package com.neweye.admin.action;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.iBatis.QnaDAO_iBatis;
import com.neweye.action.Action;
import com.neweye.dao.QnaDAO;
import com.neweye.dto.QnaVO;

public class AdminQnaListAction implements Action {

  /*@Override
  public String adminQnaList(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "qna/qnaList.jsp";
    
    QnaDAO qnaDAO = QnaDAO_JDBC.getInstance();
    QnaDAO qnaDAO = QnaDAO_iBatis.getInstance();
    ArrayList<QnaVO> qnaList=null;
	try {
		qnaList = qnaDAO.listAllQna();
	} catch (SQLException e) {
		e.printStackTrace();
	}

    request.setAttribute("qnaList", qnaList);

    return url;
  }*/
}
