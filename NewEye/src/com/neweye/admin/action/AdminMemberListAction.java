package com.neweye.admin.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.iBatis.MemberDAO_iBatis;
import com.neweye.action.Action;
import com.neweye.dao.MemberDAO;
import com.neweye.dto.MemberVO;

public class AdminMemberListAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "member/memberList.jsp";
    String key = "";
    if (request.getParameter("key") != null) {
      key = request.getParameter("key");
    }

    MemberDAO memberDAO = MemberDAO_iBatis.getInstance();
    ArrayList<MemberVO> memberList=null;
	try {
		memberList = memberDAO.listMember(key);
	} catch (SQLException e) {
		e.printStackTrace();
	}

    request.setAttribute("memberList", memberList);

    return url;
  }
}
