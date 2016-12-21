package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.dao.OrderDAO;
import com.neweye.dao.iBatis.OrderDAO_iBatis;
import com.neweye.dto.MemberVO;
import com.neweye.dto.OrderVO;

public class OrderAllAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/mypage.jsp";

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			url = "loginForm.ne";
		} else {
			OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
			ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();

			try {
				ArrayList<Integer> oseqList = orderDAO.selectSeqOrderTotal(loginUser.getId());
				for (int oseq : oseqList) {
					ArrayList<OrderVO> orderListIng = orderDAO.listOrderById(loginUser.getId(), "%", oseq);

					OrderVO orderVO = orderListIng.get(0);
					orderVO.setPname(orderVO.getPname() + " 외 " + orderListIng.size() + "건");

					int totalPrice = 0;
					for (OrderVO ovo : orderListIng) {
						totalPrice += ovo.getPrice2() * ovo.getQuantity();
					}
					orderVO.setPrice2(totalPrice);
					orderList.add(orderVO);
				}
				request.setAttribute("title", "총 주문 내역");
				request.setAttribute("orderList", orderList);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return url;
	}
}
