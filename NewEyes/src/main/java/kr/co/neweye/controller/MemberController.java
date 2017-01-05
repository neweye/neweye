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
import org.springframework.validation.BindingResult;
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
	public String login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "redirect:login_fail";
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
		            url = "redirect:/?login=1";
		            //url = request.getContextPath()+"/mypage/login?login=1";
		         }
		   }else{
		          
		   }
		      }
		return url;
	}
	
	@RequestMapping("/mypageForm")
	   public String mypageForm(HttpServletRequest request,
	         HttpServletResponse response) throws ServletException, IOException {
	      String url = "/mypage/myPageForm";

	      return url;
	   }
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url= "redirect:/";
		
		HttpSession session=request.getSession(false);
		
		if(session!=null){
		session.invalidate();
		}
		return url;	
	}
	
	
	
	
	
	@RequestMapping(value="/mypageMember", method=RequestMethod.GET)
	   public String mypageMember(HttpServletRequest request,
	         HttpServletResponse response) throws ServletException, IOException {
	      String url = "/mypage/myPageMember";
	            

	      return url;
	   }

	@RequestMapping(value="/mypageMember", method=RequestMethod.POST)
	   public String mypageMemberUpdate(HttpServletRequest request,
	         HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("utf-8");
	      //String url = "/mypage/myPageForm";
	      String url = "redirect:mypageMember";
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
	         message="success";
	         updatemember = memberDAO.getMember(request.getParameter("id").trim());
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	            
	      session.setAttribute("loginUser", updatemember);
	      request.setAttribute("message", message);   

	      return url;
	   }	
	
	@RequestMapping("/mypageMemberDelete")
	public String mypageMemberDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "/mypage/myPageForm";
		
		String id = request.getParameter("id");
		System.out.println(id);
		HttpSession session = request.getSession();
		
		MemberDAO memberDAO = MemberDAO_iBatis.getInstance();
		int memberVO=1;
		
		try {
			memberVO = memberDAO.deleteMember(id);
			session.invalidate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	@RequestMapping("/deleteuseMember")
	public String deleteuseMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "/mypage/myPageForm";
		
		String id = request.getParameter("id");
		System.out.println(id);
		HttpSession session = request.getSession();
		
		MemberDAO memberDAO = MemberDAO_iBatis.getInstance();
		int memberVO=1;
		
		try {
			memberVO = memberDAO.deleteMember(id);
			session.invalidate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
		
	}
	
}
