package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.neweye.dto.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.neweye.dao.MemberDAO;
import co.kr.neweye.ibatis.MemberDAO_iBatis;

@Controller
@RequestMapping("/admin")
public class AdminMemberController {

	@RequestMapping("/adminMemberList")
	public String adminMemberList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String url = "admin/member/memberList";
		String key = "";
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
		}

		MemberDAO memberDAO = MemberDAO_iBatis.getInstance();
		ArrayList<MemberVO> memberList = null;
		try {
			memberList = memberDAO.listMember(key);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("memberList", memberList);

		return url;
	}

	@RequestMapping("/adminUpdateForm")
	public String adminUpdateForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/member/myPageMember";

		String id = request.getParameter("id");
		MemberDAO memberDAO = MemberDAO_iBatis.getInstance();

		MemberVO memberVO = null;
		try {
			memberVO = memberDAO.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("memberVO", memberVO);

		return url;
	}
	

	@RequestMapping("/adminUpdate")
	public String adminUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String url = "redirect:adminUpdateForm?id="+request.getParameter("id");
		String message = "fail";
		HttpSession session = request.getSession();

		
		MemberVO member = new MemberVO();
	      MemberVO updatemember = new MemberVO();
	      member.setId(request.getParameter("id").trim());
	      member.setPassword(request.getParameter("password"));
	      member.setEmail(request.getParameter("email"));
	      member.setAddress(request.getParameter("address"));
	      member.setName(request.getParameter("name"));
	      member.setPhone(request.getParameter("phone"));
	      member.setZipNum(request.getParameter("zipNum"));
	      
	      
	      //String id = request.getParameter("id").trim();
	            
	      MemberDAO memberDAO=MemberDAO_iBatis.getInstance();
	      try {
	         memberDAO.updateMember(member);
	         message="succes";
	         updatemember = memberDAO.getMember(request.getParameter("id").trim());
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      request.setAttribute("message", message);   


		return url;
	}

	
	@RequestMapping("/admindeleteuseMember")
	public String admindeleteuseMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "redirect:adminMemberList";
		

		String id = request.getParameter("id");
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setUseyn("n");

		MemberDAO memberDAO = MemberDAO_iBatis.getInstance();
		try {
			memberDAO.deleteuseMember(member);
			HttpSession session = request.getSession();
			session.invalidate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}
}
