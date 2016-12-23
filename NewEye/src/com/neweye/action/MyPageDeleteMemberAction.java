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

public class MyPageDeleteMemberAction implements Action{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "/mypage/myPageForm.jsp";
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		MemberDAO memberDAO = MemberDAO_iBatis.getInstance();
		int memberVO=1;
		
		try {
			memberVO = memberDAO.deleteMember(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
		
	}

}
