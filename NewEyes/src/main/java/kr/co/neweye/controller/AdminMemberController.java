package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.neweye.dto.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.neweye.dao.MemberDAO;
import co.kr.neweye.ibatis.MemberDAO_iBatis;

@Controller
@RequestMapping("/admin")
public class AdminMemberController {

	  @RequestMapping("/adminMemberList")
	  public String adminMemberList(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	    String url = "admin/member/memberList";
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
