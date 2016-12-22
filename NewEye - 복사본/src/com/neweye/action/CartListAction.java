package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.dao.CartDAO;
import com.neweye.dao.iBatis.CartDAO_iBatis;
import com.neweye.dto.CartVO;
import com.neweye.dto.MemberVO;

public class CartListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "mypage/cartList.jsp";
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			url = "loginForm.ne";
		} else {
			CartDAO cartDAO = CartDAO_iBatis.getInstance();
			/*CartDAO cartDAO = CartDAO_JDBC.getInstance();*/
			try {
				ArrayList<CartVO> cartList = cartDAO
						.listCart(loginUser.getId());
				int totalPrice = 0;
				for (CartVO cartVO : cartList) {
					totalPrice += cartVO.getPrice2() * cartVO.getQuantity();
				}
				request.setAttribute("cartList", cartList);
				request.setAttribute("totalPrice", totalPrice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return url;		
	}
}
