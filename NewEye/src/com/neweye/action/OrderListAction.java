package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.aso.e;

import com.neweye.dao.CartDAO;
import com.neweye.dao.OrderDAO;
import com.neweye.dao.iBatis.CartDAO_iBatis;
import com.neweye.dao.iBatis.OrderDAO_iBatis;
import com.neweye.dto.CartVO;
import com.neweye.dto.MemberVO;
import com.neweye.dto.OrderVO;

public class OrderListAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderList.jsp";
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		OrderVO order = new OrderVO();
		order.setSname(request.getParameter("sname"));
		order.setSphone(request.getParameter("sphone"));
		order.setMname(request.getParameter("mname"));
		order.setPhone(request.getParameter("phone"));
		order.setZipNum(request.getParameter("zipNum"));
		order.setAddress(request.getParameter("addr1")+request.getParameter("addr2"));
		order.setPay(request.getParameter("pay"));
		
		String[] cseqArr = request.getParameterValues("cseq");
		
		CartDAO cartDAO = CartDAO_iBatis.getInstance();
		OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
		
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		ArrayList<OrderVO> orderList = null;
		int totalPrice = 0;
		
		try {
			for (String cseq : cseqArr) {
				CartVO cartVO = cartDAO.getCart(cseq);
				cartList.add(cartVO);
			}
			int maxOseq = orderDAO.insertOrder(order, cartList, loginUser.getId());
			orderList = orderDAO.listOrderById(loginUser.getId(), "1", maxOseq);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (OrderVO orderVO : orderList) {
			totalPrice += orderVO.getPrice() * orderVO.getQuantity();
		}
		request.setAttribute("orderList", orderList);
		request.setAttribute("totalPrice", totalPrice);

		return url;
	}
}
