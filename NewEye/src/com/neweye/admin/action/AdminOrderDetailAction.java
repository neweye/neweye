package com.neweye.admin.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.action.Action;
import com.neweye.dao.OrderDAO;
import com.neweye.dao.iBatis.OrderDAO_iBatis;
import com.neweye.dto.MemberVO;
import com.neweye.dto.OrderVO;

public class AdminOrderDetailAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "order/orderDetail.jsp";

		int oseq = Integer.parseInt(request.getParameter("oseq"));
		OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
		ArrayList<OrderVO> orderList = null;
		try {
			orderList = orderDAO.listOrderByOseq(oseq);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int totalPrice = 0;
		for (OrderVO ovo : orderList) {
			totalPrice += ovo.getPrice() * ovo.getQuantity();
		}
		request.setAttribute("orderDetail", orderList.get(0));
		request.setAttribute("orderList", orderList);
		request.setAttribute("totalPrice", totalPrice);

		return url;
	}
}
