package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.aso.e;

import com.neweye.dao.OrderDAO;
import com.neweye.dao.iBatis.OrderDAO_iBatis;
import com.neweye.dto.MemberVO;
import com.neweye.dto.OrderVO;

public class OrderListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderList.jsp";

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			url = "loginForm.ne";
		} else {
			OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
			int oseq = Integer.parseInt(request.getParameter("oseq"));
			ArrayList<OrderVO> orderList = null;
			int totalPrice = 0;

			try {
				orderList = orderDAO.listOrderById(loginUser.getId(), "1", oseq);

				for (OrderVO orderVO : orderList) {
					totalPrice += orderVO.getPrice() * orderVO.getQuantity();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("orderList", orderList);
			request.setAttribute("totalPrice", totalPrice);
		}
		return url;
	}
}
