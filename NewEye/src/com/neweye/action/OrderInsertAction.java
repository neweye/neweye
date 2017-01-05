package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.dao.CartDAO;
import com.neweye.dao.OrderDAO;
import com.neweye.dao.iBatis.CartDAO_iBatis;
import com.neweye.dao.iBatis.OrderDAO_iBatis;
import com.neweye.dto.CartVO;
import com.neweye.dto.MemberVO;
import com.neweye.dto.OrderVO;

public class OrderInsertAction implements Action {

	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderInsert.jsp";

		CartDAO cartDAO = CartDAO_iBatis.getInstance();
		String[] cseqArr = request.getParameterValues("cseq");
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		int totalPrice = 0;
		try {
			for (String cseq : cseqArr) {
				CartVO cartVO = cartDAO.getCart(cseq);
				cartList.add(cartVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (CartVO c : cartList) {
			totalPrice += c.getPrice() * c.getQuantity();
		}
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("cartList", cartList);
		
		return url;
	}*/
}
