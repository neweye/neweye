package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.dao.iBatis.QnaDAO_iBatis;
import com.neweye.dto.MemberVO;
import com.neweye.dto.QnaVO;

public class QnaListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "qna/qnaList.jsp";

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			url = "loginForm.ne";
		} else {
			/* QnaDAO qnaDAO = QnaDAO_iBatis_iBatis.getInstance(); */
			QnaDAO_iBatis qnaDAO = QnaDAO_iBatis.getInstance();

			ArrayList<QnaVO> qnaList=null;
			try {
				qnaList = qnaDAO.listQna(loginUser.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("qnaList", qnaList);
		}
		return url;
	}
}
