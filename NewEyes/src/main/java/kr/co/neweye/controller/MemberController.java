package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.neweye.dto.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.neweye.dao.MemberDAO;
import co.kr.neweye.ibatis.MemberDAO_iBatis;

@Controller
public class MemberController {
	@RequestMapping(value="/loginForm",method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/login";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if (loginUser != null) {
			url = "/";		
		} 
		
		return url;	
	}
	
	@RequestMapping("/login")
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login_fail";
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// MemberDAO memberDAO = MemberDAO_JDBC.getInstance();
		MemberDAO memberDAO = MemberDAO_iBatis.getInstance();
		MemberVO memberVO = null;

		String useyn = "y";
		try {
			memberVO = memberDAO.getMember(id);
			if (memberVO != null) {
				useyn = memberVO.getUseyn();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (memberVO != null) {
		    if(useyn.equals("y")){
		         if (memberVO.getPassword().equals(password)) {
		            session.removeAttribute("id");
		            session.setAttribute("loginUser", memberVO);
		            url = "/?login=1";
		            //url = request.getContextPath()+"/mypage/login?login=1";
		         }
		   }else{
		          
		   }
		      }
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}
	
	@RequestMapping("/mypageForm")
	   public String mypageForm(HttpServletRequest request,
	         HttpServletResponse response) throws ServletException, IOException {
	      String url = "/mypage/myPageForm";

	      return url;
	   }
}
