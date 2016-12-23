package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.dao.MemberDAO;
import com.neweye.dao.iBatis.MemberDAO_iBatis;
import com.neweye.dto.MemberVO;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/login_fail.jsp";
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//MemberDAO memberDAO = MemberDAO_JDBC.getInstance();
		MemberDAO memberDAO = MemberDAO_iBatis.getInstance();
		MemberVO memberVO=null;
		try {
			memberVO = memberDAO.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (memberVO != null) {
			if (memberVO.getPassword().equals(password)) {
				session.removeAttribute("id");
				session.setAttribute("loginUser", memberVO);
				url = "index.ne?login=1";
			}
		}
		return url;
	}

}
