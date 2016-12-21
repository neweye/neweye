package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.dao.QnaDAO;
import com.neweye.dao.iBatis.QnaDAO_iBatis;
import com.neweye.dto.MemberVO;
import com.neweye.dto.QnaVO;

public class QnaViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "qna/qnaView.jsp";

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			url = "loginForm.ne";
		} else {
			int qseq = Integer.parseInt(request.getParameter("qseq"));
			/* QnaDAO qnaDAO = QnaDAO_JDBC.getInstance(); */
			QnaDAO qnaDAO = QnaDAO_iBatis.getInstance();
			QnaVO qnaVO = null;
			try {
				qnaVO = qnaDAO.getQna(qseq);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("qnaVO", qnaVO);
		}
		return url;
	}
}
