package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.neweye.dto.CartVO;
import kr.co.neweye.dto.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.neweye.dao.CartDAO;
import co.kr.neweye.ibatis.CartDAO_iBatis;



@Controller
public class CartController {


	@RequestMapping("/cartList")
	public String cartList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "mypage/cartList";
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		
			CartDAO cartDAO = CartDAO_iBatis.getInstance();
			/*CartDAO cartDAO = CartDAO_JDBC.getInstance();*/
			try {
				ArrayList<CartVO> cartList = cartDAO
						.listCart(loginUser.getId());
				int totalPrice = 0;
				for (CartVO cartVO : cartList) {
					totalPrice += cartVO.getPrice() * cartVO.getQuantity();
				}
				request.setAttribute("cartList", cartList);
				request.setAttribute("totalPrice", totalPrice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return url;		
	}
	
	
	
	
	
	@RequestMapping("/cartInsert")
	public String cartInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "redirect:cartList";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
			CartVO cartVO = new CartVO();
			
			try {
			cartVO.setId(loginUser.getId());
			String str=request.getParameter("pseq");
			if(str != null) {
			cartVO.setPseq(Integer.parseInt(str.trim()));
			} else {
				//decide what to do when end of file
			}
			
			cartVO.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			
			CartDAO cartDAO = CartDAO_iBatis.getInstance();
				cartDAO.insertCart(cartVO);
			

				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		return url;
	}
	
	
	@RequestMapping("/cartDelete")
	public String cartDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "redirect:cartList";

		String[] cseqArr = request.getParameterValues("cseq");

		for (String cseq : cseqArr) {			
			CartDAO cartDAO = CartDAO_iBatis.getInstance();
			try {
				cartDAO.deleteCart(Integer.parseInt(cseq));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return url;
	}
	

}
