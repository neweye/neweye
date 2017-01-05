package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.neweye.dto.AddressVO;
import kr.co.neweye.dto.MemberVO;
import kr.co.neweye.dto.QnaVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.neweye.dao.AddressDAO;
import co.kr.neweye.dao.MemberDAO;
import co.kr.neweye.dao.QnaDAO;
import co.kr.neweye.ibatis.AddressDAO_iBatis;
import co.kr.neweye.ibatis.MemberDAO_iBatis;
import co.kr.neweye.ibatis.QnaDAO_iBatis;

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
	
	@RequestMapping("/findIdForm")
	public String findIdForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "/member/findIdForm";		
		
		return url;
	}
	
	
	
	@RequestMapping("/findId")
	public String findId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "/member/findIdForm";
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		MemberDAO memberDAO=MemberDAO_iBatis.getInstance();
		MemberVO member=null;
		try {
			member = (MemberVO)memberDAO.searchId(name, phone);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("member", member);
		return url;
	}
	
	@RequestMapping("/joinForm")
	public String joinForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/member/join";		
		
		return url;

	}
	
	@RequestMapping("/contract")
	public String contract(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "/member/contract";		
		
		return url;
	}
	
	@RequestMapping("/idCheckForm")
	public String idCheckForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/member/idcheck";
		String id = request.getParameter("id").trim();
		
		//MemberDAO memberDAO=MemberDAO_JDBC.getInstance();		
		MemberDAO memberDAO=MemberDAO_iBatis.getInstance();
		int message=-1;
		try {
			message = memberDAO.confirmID(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("id", id);
		
		return url;
	}
	
	@RequestMapping("/findZipNum")
	public String findZipNum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String url = "member/findZipNum";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String dong = request.getParameter("dong");

		if (dong != null && dong.trim().equals("") == false) {
			//AddressDAO addressDAO = AddressDAO_JDBC.getInstance();
			AddressDAO addressDAO = AddressDAO_iBatis.getInstance();
			try {
				ArrayList<AddressVO> addressList = addressDAO
						.selectAddressByDong(dong.trim());
				request.setAttribute("addressList", addressList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return url;
	}
	
	@RequestMapping("/qnaList")
	public String qnaList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "qna/qnaList";

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			url = "loginForm";
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
	
	@RequestMapping("/qnaWriteForm")
	  public String qnaWriteForm(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String url = "qna/qnaWrite";
	    
	    HttpSession session = request.getSession();
	    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");    
	    
	    if (loginUser == null) {
	      url = "loginForm";
	    } 
	    
	    return url;
	  }
	
	
	@RequestMapping("/qnaWrite")
	public String qnaWrite(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "qna/qnaList";
			
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			url = "loginForm";
		} else {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setSubject(request.getParameter("subject"));
			qnaVO.setContent(request.getParameter("content"));
			/* QnaDAO qnaDAO = QnaDAO_JDBC.getInstance(); */
			QnaDAO qnaDAO = QnaDAO_iBatis.getInstance();
			try {
				qnaDAO.insertqna(qnaVO, loginUser.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return url;
	}
	
}
