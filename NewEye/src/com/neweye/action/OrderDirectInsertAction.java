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

public class OrderDirectInsertAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "orderList.ne";

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			url = "loginForm.ne";
		} else {
			ArrayList<CartVO> cartList =new ArrayList<CartVO>();
			CartVO cartVO = new CartVO();
			cartVO.setId(loginUser.getId());
			cartVO.setPseq(Integer.parseInt(request.getParameter("pseq")));
			cartVO.setQuantity(Integer.parseInt(request
					.getParameter("quantity")));
			cartList.add(cartVO);
			OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
			try {				 
				int maxOseq = orderDAO.insertOrder(cartList, loginUser.getId());
				url = "orderList.ne?oseq=" + maxOseq;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return url;
	}
}
