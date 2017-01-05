package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;

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

	@RequestMapping("/cartInsert")
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "cartList.ne";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			url = "loginForm.ne";
		} else {
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
		}
		return url;
	}

}
