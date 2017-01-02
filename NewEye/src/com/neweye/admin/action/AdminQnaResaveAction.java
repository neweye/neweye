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

public class AdminQnaResaveAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String url = "adminQnaList.ne";
		
		System.out.println("1111");
		String qseq = request.getParameter("qseq").trim();
		System.out.println("22222");
		String reply = request.getParameter("reply"); //여기서 에러
		System.out.println("33333");
		System.out.println("테스트:"+request.getParameter(reply));

		QnaVO qnaVO = new QnaVO();
		qnaVO.setQseq(Integer.parseInt(qseq));
		qnaVO.setReply(reply);

		/* QnaDAO qnaDAO = QnaDAO_JDBC.getInstance(); */
		QnaDAO qnaDAO = QnaDAO_iBatis.getInstance();
		try {
			qnaDAO.updateQna(qnaVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return url;
	}
}
